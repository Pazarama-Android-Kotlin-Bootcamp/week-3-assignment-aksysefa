package com.aksoysefa.week3assignment


import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class bookModel(
    val bookName: String,
    val author: String,
    val brief: String,
    val bookImage: Int

):Parcelable {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(jsonValue: String): bookModel {
            return Gson().fromJson(jsonValue, bookModel::class.java)
        }
    }
}

val mockData = mutableListOf<bookModel>(
    bookModel(
        "Sefiller",
        "Victor Hugo",
        "Jan Valjean, yoksul bir köylüdür, ailesini doyurmak amacıyla çaldığı yalnızca bir somun ekmekten dolayı kürek cezasına çarptırılmış, defalarca kaçma teşebbüsünde bulunduğundan cezası katlanmış ve on dokuz seneye cıkmıştır.",
        R.drawable.sefiller

    ),
    bookModel(
        "oblomov",
        "İvan Gonçarov",
        "Oblomovka, yaşayışı, gelenekleri, inanışları, aile kuruluşu, çalışma düzeniyle eski Rusya'dır.",
        R.drawable.oblomov

    ),
    bookModel(
        "suç ve ceza",
        "Dostoyevski",
        "Suç ve Ceza; Rodion Romanoviç Raskolnikov adındaki bir gencin işlediği çifte cinayet üzerine yaşadıklarını konu alıyor.",
        R.drawable.sucveceza

    ),
    bookModel(
        "şeker portakalı",
        "José Mauro de Vasconcelos",
        "Yoksul bir ailenin beş yaşındaki oğlu olan Zeze, yaramazlıkları ile tüm mahalleye gına getiren ve yaka silktiren bir çocuktur.",
        R.drawable.sekerportakali

    )
)





