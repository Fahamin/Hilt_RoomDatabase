package com.scan.hilt_roomdatabase.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.scan.hilt_roomdatabase.DB.NoteModel
import com.scan.hilt_roomdatabase.Uitls.Constants.BUNDLE_NOTE_ID
import com.scan.hilt_roomdatabase.View.UpdateNoteActivity
import com.scan.hilt_roomdatabase.databinding.ItemNoteBinding
import javax.inject.Inject

class NoteAdapter @Inject constructor() : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private lateinit var binding: ItemNoteBinding
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val influtter = LayoutInflater.from(parent.context)
        binding = ItemNoteBinding.inflate(influtter, parent, false)
        context = parent.context
        return NoteViewHolder()
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }


    inner class NoteViewHolder() : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NoteModel) {
            binding.apply {
                tvTitle.text = item.title
                tvDesc.text = item.des

                root.setOnClickListener {
                    val intent = Intent(context, UpdateNoteActivity::class.java)
                    intent.putExtra(BUNDLE_NOTE_ID, item.id)
                    context.startActivity(intent)
                }
            }


        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

}