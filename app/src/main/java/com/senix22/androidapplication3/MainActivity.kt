package com.senix22.androidapplication3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {
    private val TAG = "My_LOG"
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideBottomSheetAtStart()
        allClicks()
    }

    private fun allClicks() {
        alert_dialog.setOnClickListener {
            showAlertDialog()
        }
        dialog_fragment.setOnClickListener {
            showDialogFragment()
        }
        bottom_sheet.setOnClickListener {
            showBottomSheet()
        }
        bottom_sheet_fragment.setOnClickListener {
            showBottomSheetFragment()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Dialog Title")
            .setMessage("Dialog message")
            .setIcon(R.drawable.ic_launcher_background)
            .setPositiveButton("Positive ") { _, _ ->
                Log.d(TAG, "Positive was clicked")
            }
            .setNegativeButton("Negative") { _, _ ->
                Log.d(TAG, "Negative was clicked")
            }
            .show()
    }

    private fun showDialogFragment() {
        supportFragmentManager.beginTransaction()
            .add(DialogFragmentExample(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun hideBottomSheetAtStart() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN;
    }

    private fun showBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED;
    }

    private fun showBottomSheetFragment() {
        supportFragmentManager.beginTransaction()
            .add(BottomSheetDialogFragment(), "TAG")
            .commitNowAllowingStateLoss()
    }

}