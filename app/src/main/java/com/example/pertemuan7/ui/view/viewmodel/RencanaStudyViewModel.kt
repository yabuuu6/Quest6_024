package com.example.pertemuan7.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan7.Data.RuangKelas
import com.example.pertemuan7.Model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel(){
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = _krsState.asStateFlow()


    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { namaMK -> namaMK.copy(namaMK = mkPilihan) }
    }


    fun setKelas(kelasPilihan: String) {
        _krsState.update { kelas -> kelas.copy(kelas = kelasPilihan) }
    }





}