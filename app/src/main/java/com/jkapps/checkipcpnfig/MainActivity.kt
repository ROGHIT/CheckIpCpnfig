package com.jkapps.checkipcpnfig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.jkapps.checkipcpnfig.data.viewmodel.MenuViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val vmMenu:MenuViewModel by lazy {
        this.let {
            ViewModelProvider(it,MenuViewModel.Factory(this,"http://${ipAddress.text.toString()}/")).get(MenuViewModel::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        action_get.setOnClickListener {
            if(!ipAddress.text.toString().isEmpty()){
                pbMain.visibility=View.VISIBLE
              /*  vmMenu.getSampleList({
                    pbMain.visibility=View.GONE
                    Log.e("Response>>>",it.toString())
                    tvDisplayJson.text=it.toString()
                },{
                    pbMain.visibility=View.GONE
                    tvDisplayJson.text=it.toString()
                    Log.e("Response>>>",it.toString())
                })*/
                vmMenu.getMenuList(id =ipAddress.text.toString(), {
                    pbMain.visibility=View.GONE
                        Log.e("Response>>>",it.toString())
                        tvDisplayJson.text=it.toString()
                    },{
                    pbMain.visibility=View.GONE
                        tvDisplayJson.text=it.toString()
                        Log.e("Response>>>",it.toString())
                    })
            }
            else
                Toast.makeText(this,"Please enter your ip",Toast.LENGTH_SHORT).show()

        }

    }
}