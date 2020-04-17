package com.example.pluginci

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages

class HelloKtAction : AnAction("Say Hi.") {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)
        // Demonstrate using 'generated' files
        val greeting = HelloProvider.getHello()
        // Demonstrate using non-Java/Kotlin files in resources directory
        val title = javaClass.classLoader.getResource("auxiliary/title.txt")?.readText() ?: return
        Messages.showMessageDialog(project, greeting, title, Messages.getInformationIcon())
    }

}