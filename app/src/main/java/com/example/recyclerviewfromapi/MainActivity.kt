package com.example.recyclerviewfromapi

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val apiInterface=APIClient().getClient()?.create(APIInterface::class.java)
    lateinit var progressDialog: ProgressDialog
    val names=ArrayList<DataItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchData()
    }
    fun fetchData(){
        funProgressDialog()
        if (apiInterface!=null){
            apiInterface.getData()?.enqueue(object : Callback<Data?> {
                override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                    progressDialog.dismiss()
                    val data=response.body()!!
                    for (dataItem in data){
                        names.add(dataItem)
                    }
                    recyclerView.adapter=RVAdapter(names)
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

                    }

                override fun onFailure(call: Call<Data?>, t: Throwable) {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
    fun funProgressDialog(){
        progressDialog= ProgressDialog(this@MainActivity)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

    }
}