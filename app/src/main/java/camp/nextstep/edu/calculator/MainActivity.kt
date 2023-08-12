package camp.nextstep.edu.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View {

    override val presenter: Contract.Presenter = ExpressionPresenter(this)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { setInputText("0") }
        binding.button1.setOnClickListener { setInputText("1") }
        binding.button2.setOnClickListener { setInputText("2") }
        binding.button3.setOnClickListener { setInputText("3") }
        binding.button4.setOnClickListener { setInputText("4") }
        binding.button5.setOnClickListener { setInputText("5") }
        binding.button6.setOnClickListener { setInputText("6") }
        binding.button7.setOnClickListener { setInputText("7") }
        binding.button8.setOnClickListener { setInputText("8") }
        binding.button9.setOnClickListener { setInputText("9") }

        binding.buttonPlus.setOnClickListener { setInputText("+") }
        binding.buttonMinus.setOnClickListener { setInputText("-") }
        binding.buttonMultiply.setOnClickListener { setInputText("*") }
        binding.buttonDivide.setOnClickListener { setInputText("/") }

        binding.buttonDelete.setOnClickListener { setRemoveText() }
        binding.buttonEquals.setOnClickListener { setEqualsText() }
    }

    override fun display(text: String) {
        binding.textView.text = text
    }

    override fun displayExpressionError() {
        Toast.makeText(this@MainActivity, "완성되지 않은 수식입니다", Toast.LENGTH_SHORT).show()
    }

    private fun setInputText(inputText: String) {
        presenter.addExpressionText(inputText)
    }

    private fun setRemoveText() {
        presenter.removeExpressionItem()
    }

    private fun setEqualsText() {
        presenter.calculate()
    }
}
