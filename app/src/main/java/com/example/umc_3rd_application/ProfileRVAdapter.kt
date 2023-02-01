package com.example.umc_3rd_application

import android.provider.ContactsContract.Profile
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_3rd_application.databinding.Profile2ItemBinding

class ProfileRVAdapter(private val dataList : ArrayList<Profile2Data>) :
    RecyclerView.Adapter<ProfileRVAdapter.Profile2DataViewHolder>()
{
    inner class Profile2DataViewHolder(private val viewBinding : Profile2ItemBinding)
        : RecyclerView.ViewHolder(viewBinding.root)
    {
        fun bind (data: Profile2Data)
        {
            viewBinding.btn1.text = data.personality1
            viewBinding.btn2.text = data.personality2
            viewBinding.btn3.text = data.personality3
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Profile2DataViewHolder {
        val viewBinding = Profile2ItemBinding.inflate(
            LayoutInflater.from(
                parent.context),parent,false)
        return Profile2DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: Profile2DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun add(data : Profile2Data)
    {
        dataList.add(data)
    }
}
