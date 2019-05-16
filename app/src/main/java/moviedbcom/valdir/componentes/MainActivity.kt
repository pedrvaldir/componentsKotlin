package moviedbcom.valdir.componentes

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonToastMe) {
            //Armazenando a referencia
            val toast = Toast.makeText(this, "Toast Notification!", Toast.LENGTH_LONG)
            //layout padrão da toast
            //toast.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.BLUE)
            //--> intanciar layout
            val inflater: LayoutInflater = layoutInflater
            val toastLayout = inflater.inflate(R.layout.toast_custom, null)
            toast.view = toastLayout

            val textView = toast.view.findViewById<TextView>(R.id.textMessage)
            textView.setTextColor(Color.MAGENTA)
            textView.text = "Toast Notification"

            toast.show()
        }
    }

    private fun setListeners() {
        buttonToastMe.setOnClickListener(this)
    }
}
