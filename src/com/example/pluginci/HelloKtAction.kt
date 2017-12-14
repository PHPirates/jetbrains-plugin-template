package com.example.pluginci

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages

class HelloKtAction : AnAction("Say Hi.") {

    override fun actionPerformed(e: AnActionEvent?) {
        val project = e?.getData(PlatformDataKeys.PROJECT)
        val greeting = HelloProvider.getHello()
        Messages.showMessageDialog(project, greeting, "GreetingKt", Messages.getInformationIcon())
    }

}