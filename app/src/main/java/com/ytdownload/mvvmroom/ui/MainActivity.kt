package com.ytdownload.mvvmroom.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.ytdownload.mvvmroom.R
import com.ytdownload.mvvmroom.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var inputAdapter: InputAdapter

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupInputList()
        setupListener()
    }

    private fun setupInputList() {
        binding.rvInput.adapter = inputAdapter

        inputAdapter.setItemDeleteClick {
            viewModel.delete(it)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.data.collectLatest {
                inputAdapter.submitList(it)
                binding.tvNoData.isVisible = it.isEmpty()
            }
        }
    }

    private fun setupListener() {
        binding.btnInput.setOnClickListener {
            val text = binding.edtInput.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this@MainActivity, "Please input somethings", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.insert(text)
                binding.edtInput.setText("")
            }
        }
    }
}