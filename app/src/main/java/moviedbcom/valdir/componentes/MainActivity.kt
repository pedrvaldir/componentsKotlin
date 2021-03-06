package moviedbcom.valdir.componentes

import android.app.ProgressDialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener,
    SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
        loadSpinner()
    }

    private fun loadSpinner() {
        val list = Mock.getList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        spinnerDynamic.adapter = adapter
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
        } else if (id == R.id.buttonSnackMe) {
            //View ficar em cima da layout constraintLayout
            val snack = Snackbar.make(constraintLayout, "Snack bar notification", Snackbar.LENGTH_SHORT)

            //  Cor do texto
            snack.view.findViewById<TextView>(android.support.design.R.id.snackbar_text).setTextColor(Color.YELLOW)

            //Cor do backgroung
            //snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
            snack.view.setBackgroundColor(Color.YELLOW)
            // pegar a cor do arquivo de colors
            //resources.getColor(R.color.colorAccent)
            ContextCompat.getColor(this, R.color.colorAccent)

            //mostrar imp da action * poderia implementar o onclicklistenhirs passando this, mas ficara mais simples aqui
            snack.setAction("Desfazer", {
                Snackbar.make(constraintLayout, "Ação desfeita", Snackbar.LENGTH_SHORT).show()
            })

            //cor do texto da action
            snack.setActionTextColor(Color.YELLOW)

            snack.show()


        } else if (id == R.id.buttonGetSpinner) {
            //val value = spinnerDynamic.selectedItem.toString()
            val value = spinnerDynamic.selectedItemPosition.toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        } else if (id == R.id.buttonSetSpinner) {
            spinner.setSelection(3)
        } else if (id == R.id.buttonProgress) {
            val progress: ProgressDialog = ProgressDialog(this)
            progress.setTitle("titulo")
            progress.setMessage("mensagem")
            progress.show()

            // progress.hide()
            //progress.dismiss()
        } else if (id == R.id.buttonGetSeek) {
             val value =   seekValue.progress.toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        } else if (id == R.id.buttonSetSeek) {
            seekValue.progress = 10
        }
    }

    private fun setListeners() {
        buttonToastMe.setOnClickListener(this)
        buttonSnackMe.setOnClickListener(this)
        buttonGetSpinner.setOnClickListener(this)
        buttonSetSpinner.setOnClickListener(this)
        buttonProgress.setOnClickListener(this)
        buttonGetSeek.setOnClickListener(this)
        buttonSetSeek.setOnClickListener(this)
        spinnerDynamic.onItemSelectedListener = this

        seekValue.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        val id = seekBar.id
        if (id == R.id.seekValue){
            textSeekValue.text = progress.toString()
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
    }


    override fun onNothingSelected(parent: AdapterView<*>) {
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val id = view.id
        if (id == R.id.spinnerDynamic){
            val value: String = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        }

    }
}
