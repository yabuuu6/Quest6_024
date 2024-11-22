package com.example.pertemuan7.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan7.Data.MataKuliah
import com.example.pertemuan7.Data.RuangKelas
import com.example.pertemuan7.Model.Mahasiswa
import com.example.pertemuan7.R
import com.example.pertemuan7.ui.view.widget.DynamicSelectedField


@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButton: (MutableList<String>) -> Unit,
    onbackbuttonClicked: () -> Unit,
) {
    var chosenDropdown by remember {
        mutableStateOf("")
    }


    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember {
        mutableStateOf("")
    }


    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihanKelas)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo Section
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.umy),
                    contentDescription = "Logo",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(16.dp)) // Jarak antara gambar dan teks
                Column(
                    modifier = Modifier.width(IntrinsicSize.Max)
                ) {
                    Text(
                        text = mahasiswa.nama,
                        color = Color.Red,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = mahasiswa.nim,
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Serif,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
// Bell Icon Section
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
// Form Section
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Title and Description
                Text(
                    text = "Pilih Mata Kuliah Peminatan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Silahkan pilih mata kuliah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )


                Spacer(modifier = Modifier.padding(8.dp))


                // Mata Kuliah Dropdown
                DynamicSelectedField(
                    selectedValue = chosenDropdown,
                    options = MataKuliah.options,
                    label = "Mata Kuliah",
                    onValueChangedEvent = {
                        chosenDropdown = it
                    }
                )

                Spacer(modifier = Modifier.padding(8.dp))


                // Divider
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


                // Kelas Selection
                Text(
                    text = "Silahkan pilih Kelas dari mata kuliah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )


                Spacer(modifier = Modifier.padding(8.dp))

// Kelas Options
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RuangKelas.kelas.forEach { data ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = pilihanKelas == data,
                                onClick = { pilihanKelas = data }
                            )
                            Text(text = data, style = androidx.compose.ui.text.TextStyle(fontSize = 12.sp))
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))



                // Divider
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


                // Klausul Persetujuan Mahasiswa
                Text(text = "Klausul Persetujuan Mahasiswa", fontWeight = FontWeight.Bold)


                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        enabled = chosenDropdown.isNotBlank() && pilihanKelas.isNotBlank()
                    )
                    Text(
                        text = "Saya Menyetujui setiap pernyataan yang ada tanpa ada paksaan dari pihak manapun.",
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))


                // Buttons Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Back Button
                    Button(
                        onClick = { onbackbuttonClicked() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.primary),
                            contentColor = Color.White
                        ),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Kembali")
                    }
// Next Button
                    Button(
                        onClick = { onSubmitButton(listData) },
                        enabled = checked,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.primary),
                            contentColor = Color.White
                        ),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Berikutnya")
                    }
                }
            }
        }
    }
}