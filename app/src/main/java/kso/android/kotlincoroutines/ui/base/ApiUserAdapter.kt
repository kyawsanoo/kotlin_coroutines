package kso.android.kotlincoroutines.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kso.android.kotlincoroutines.R
import kso.android.kotlincoroutines.data.model.ApiUser

class ApiUserAdapter(
    private val users: ArrayList<ApiUser>
) : RecyclerView.Adapter<ApiUserAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewAvatar by lazy { itemView.findViewById<ImageView>(R.id.imageViewAvatar) }
        private val textViewUserName by lazy { itemView.findViewById<AppCompatTextView>(R.id.textViewUserName) }
        private val textViewUserEmail by lazy { itemView.findViewById<AppCompatTextView>(R.id.textViewUserEmail) }

        fun bind(user: ApiUser) {
            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            Glide.with(imageViewAvatar.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<ApiUser>) {
        users.addAll(list)
    }

}