package com.example.memestation.framework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.example.memestation.BuildConfig
import com.example.memestation.bussiness.interactors.MemeRepository
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.GPHSettings
import com.giphy.sdk.ui.Giphy
import com.giphy.sdk.ui.themes.GPHTheme
import com.giphy.sdk.ui.themes.GridType
import com.giphy.sdk.ui.views.GiphyDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GiphyDialogFragment.GifSelectionListener {

  private val memeViewModel : MemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        memeViewModel.startCheck()
        memeViewModel.dataCheck.observe(this, Observer { dataCheck ->

            Log.d("ApiCheck", dataCheck.toString())

        })

        setContent {
                MyButton()
        }

        /*photoEditorView.getSource().setImageResource(R.drawable.bg2xxxhdpi);
        val mTextRobotoTf = ResourcesCompat.getFont(this, R.font.roboto_medium);
        val mEmojiTypeFace = Typeface.createFromAsset(assets, "emojione-android.ttf");
        val photoeditor = PhotoEditor.Builder(this, photoEditorView)
            .setPinchTextScalable(true)
            .setDefaultTextTypeface(mTextRobotoTf)
            .setDefaultEmojiTypeface(mEmojiTypeFace)
            .build()

        photoeditor.addText("Hey, I learned everything HAHA!", R.color.purple_200)
*/

    }

    @Preview
    @Composable
    fun MyButton() {

      Column(modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment =  Alignment.CenterHorizontally) {

          Button(onClick = { initialiseGiphy() },
              modifier = Modifier.padding(all = Dp(10F)),
             enabled = true,
              border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
              shape = MaterialTheme.shapes.medium) {

              Text(text = "Testing GIPHY", color = Color.White)

          }

      }
    }

    //This piece of code kicks off execution of Giphy SDK
    private fun initialiseGiphy() {


        Giphy.configure(context = this, BuildConfig.GIPHY_API_KEY)
        val settings = GPHSettings(GridType.waterfall, GPHTheme.Dark)
        val gifsDialog = GiphyDialogFragment.newInstance(settings)
        settings.showConfirmationScreen = true
        gifsDialog.show(supportFragmentManager, "gifs_dialog")
        //GiphyDialogFragment.newInstance().show(supportFragmentManager, "giphy_dialog")


    }

    override fun didSearchTerm(term: String) {
        TODO("Not yet implemented")
    }

    override fun onDismissed(selectedContentType: GPHContentType) {
        TODO("Not yet implemented")
    }

    override fun onGifSelected(
        media: Media,
        searchTerm: String?,
        selectedContentType: GPHContentType
    ) {
        Toast.makeText(this, "Gif Selected", Toast.LENGTH_SHORT).show()
    }

}