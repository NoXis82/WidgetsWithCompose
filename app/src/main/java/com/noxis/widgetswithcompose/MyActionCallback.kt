package com.noxis.widgetswithcompose

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState

class MyActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { mutablePreferences ->
            val currentCount = mutablePreferences[MyAppWidget.countKey]
            if (currentCount != null) {
                mutablePreferences[MyAppWidget.countKey] = currentCount + 1
            } else {
                mutablePreferences[MyAppWidget.countKey] = 1
            }
            MyAppWidget.update(context, glanceId)
        }

    }
}
