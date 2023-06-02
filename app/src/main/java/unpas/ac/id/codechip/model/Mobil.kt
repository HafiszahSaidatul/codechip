package unpas.ac.id.codechip.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mobil (
    @PrimaryKey val id: String,
    val merk: String,
    val model:String,
    val bahan_bakar:String,
    val dijual:String,
    val deskripsi: String,
)

//enum class Pendidikan (val pendidikan: String) {
//    s2("S2"),
//    s3("S3")
//}