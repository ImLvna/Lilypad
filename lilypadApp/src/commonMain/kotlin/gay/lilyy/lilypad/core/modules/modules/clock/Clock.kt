package gay.lilyy.lilypad.core.modules.modules.clock

import androidx.compose.runtime.*
import gay.lilyy.lilypad.core.CoreModules.Coremodules.chatbox.ChatboxModule
import gay.lilyy.lilypad.ui.components.LabeledCheckbox
import kotlinx.serialization.Serializable
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Serializable
data class ClockConfig(
    var enabled: Boolean = false
)

@Suppress("unused")
class Clock : ChatboxModule<ClockConfig>() {
    override val name = "Clock"

    override val configClass = ClockConfig::class

    private val formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)

    override val chatboxBuildOrder = 1
    override fun buildChatbox(): List<String> {
        if (config!!.enabled) {
            // Format based on the user's locale
            val time = LocalTime.now()
            return listOf(time.format(formatter))
        }
        return emptyList()
    }

    override val hasSettingsUI = true

    @Composable
    override fun onSettingsUI() {
        var enabled by remember { mutableStateOf(config!!.enabled) }
        LabeledCheckbox(
            label = "Enabled",
            checked = enabled,
            onCheckedChange = {
                enabled = it
                config!!.enabled = it
                saveConfig()
            }
        )
    }
}