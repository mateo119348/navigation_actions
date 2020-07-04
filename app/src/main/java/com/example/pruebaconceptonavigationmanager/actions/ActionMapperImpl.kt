package com.example.pruebaconceptonavigationmanager.actions

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.navigation.action.Action
import com.example.navigation.action.ActionMapper
import com.example.navigation.action.BUNDLE_FIELDS
import com.example.navigation.action.RuleAction
import com.example.navigation.stepsEngine.field.Field
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy


class ActionMapperImpl(var context: Context) : ActionMapper {

    private val INTERNAL = "INTERNAL"
    var deepLinks : DeepLinkMapping

    init {
        val mapper = ObjectMapper()
        mapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        val inputStreamActions= context.assets.open("actionsMapping/MLA.json")
        deepLinks = mapper.readValue(inputStreamActions, object : TypeReference<DeepLinkMapping>() {})
    }
    /**
     * Inicia una instancia de Action a partir de un deep link
     * @param action nodo que representa un action del json
     * @param params
     */
    override fun startAction(action: RuleAction) {
        val name = action.id
        val deepLink = getDeepLink(name)
        initAction(deepLink!!, action.getFields())
    }

    /**
     * Sobre una Action ya activa, ejecuta en base a nuevos fields requeridos por otro step
     * @param action  Action activa (pantalla)
     * @param params
     */
    override fun executeNextField(action: Action, vararg params: Any?) {
        action.executeFields(params[0] as List<Field>)
    }

    private fun getDeepLink(actionName: String?): String? {
        return deepLinks.actions!![actionName]
    }

    private fun initAction(deepLink: String, fields: ArrayList<Field>?) {
        val uri = Uri.parse(deepLink)
        val intent = getSafeIntent(context)
        intent!!.data = uri
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putParcelableArrayListExtra(BUNDLE_FIELDS, fields)
        context.startActivity(intent)
    }

    private fun getSafeIntent(context: Context): Intent? {
        return Intent(Intent.ACTION_VIEW).setPackage(context.packageName).putExtra(INTERNAL, true)
    }

}