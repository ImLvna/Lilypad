package gay.lilyy.lilypad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import gay.lilyy.lilypad.core.globalInit
import gay.lilyy.lilypad.ui.app

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        globalInit()
        registerPreCloseListener()
        super.onCreate(savedInstanceState)

        Shared.context = applicationContext

        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    app()
}