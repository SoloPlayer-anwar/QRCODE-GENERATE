package com.testing.qrcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.qrcode.encoder.QRCode
import com.testing.qrcode.databinding.ActivityMainBinding
import com.testing.qrcode.scan.ScannerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerate.setOnClickListener {
            val etText = binding.etText.text.toString()
            val generateCode = QRGEncoder(etText, null,QRGContents.Type.TEXT, 800)
            binding.rqCode.setImageBitmap(generateCode.bitmap)
        }

        binding.btnPindah.setOnClickListener {
            val intent = Intent(this, ScannerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}