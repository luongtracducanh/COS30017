package au.edu.swin.sdmd.core3_local

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.bottomsheet_fragment, container, false)

        val name = view.findViewById<TextView>(R.id.detailName)
        val code = view.findViewById<TextView>(R.id.detailCode)
        val gold = view.findViewById<TextView>(R.id.gold)
        val silver = view.findViewById<TextView>(R.id.silver)
        val bronze = view.findViewById<TextView>(R.id.bronze)

        val tempName = arguments?.getString("name")
        val tempCode = arguments?.getString("code")
        val tempGold = arguments?.getInt("gold")
        val tempSilver = arguments?.getInt("silver")
        val tempBronze = arguments?.getInt("bronze")

        name.text = tempName
        code.text = tempCode
        gold.text = "$tempGold gold medals"
        silver.text = "$tempSilver silver medals"
        bronze.text = "$tempBronze bronze medals"

        return view
    }
}