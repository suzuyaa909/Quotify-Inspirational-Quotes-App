package com.example.quotesapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quotesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val quotesList = ArrayList<String>()
    var index:Int = 0

    private var array = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Adding quotes in arraylist
       // addQuotesWithArrayList()

        //if you can use this method you can comment above method
        /** Similar functionality with model class
         *added model class in arraylist for storing value**/
        addQuotesWithModel()

    }

    fun addQuotesWithArrayList(){
        //Adding quotes in arraylist
          addQuotes()

          binding.quoteText.text = quotesList[0]
          binding.btnnext.setOnClickListener {
              next()
          }
          binding.btnprevios.setOnClickListener {
              previous()
          }
          binding.btnShare.setOnClickListener {
              onShare()
          }
    }

    fun addQuotes()
    {
        quotesList.add("If one way be better than another, that you may be sure is natures way.")
        quotesList.add("It is not in the stars to hold our destiny but in ourselves.")
        quotesList.add("I will prepare and some day my chance will come.")
        quotesList.add("Sometimes the cards we are dealt are not always fair. However you must keep smiling and moving on.")
        quotesList.add("What we see depends mainly on what we look for.")
        quotesList.add("If one way be better than another, that you may be sure is natures way.")
        quotesList.add("It is not in the stars to hold our destiny but in ourselves.")
        quotesList.add("If one way be better than another, that you may be sure is natures way.")
        quotesList.add("It is not in the stars to hold our destiny but in ourselves.")
        quotesList.add("I will prepare and some day my chance will come.")
        quotesList.add("Sometimes the cards we are dealt are not always fair. However you must keep smiling and moving on.")
        quotesList.add("What we see depends mainly on what we look for.")
        quotesList.add("If one way be better than another, that you may be sure is natures way.")
        quotesList.add("It is not in the stars to hold our destiny but in ourselves.")
        quotesList.add("If one way be better than another, that you may be sure is natures way.")
        quotesList.add("It is not in the stars to hold our destiny but in ourselves.")
        quotesList.add("I will prepare and some day my chance will come.")
        quotesList.add("Sometimes the cards we are dealt are not always fair. However you must keep smiling and moving on.")
        quotesList.add("What we see depends mainly on what we look for.")
        quotesList.add("If one way be better than another, that you may be sure is natures way.")
        quotesList.add("It is not in the stars to hold our destiny but in ourselves.")
    }

    fun next()
    {
        if(index <quotesList.size-1){
            index++
            binding.quoteText.text = quotesList[index]
        }
    }

    fun previous()
    {
        if(index >0){
            index--
            binding.quoteText.text = quotesList[index]
        }
    }

    fun onShare()
    {
        val str:String= binding.quoteText.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,str)
        startActivity(intent)
    }


    private fun addQuotesWithModel() {

        addQuestDataList()

        binding.btnnext.setOnClickListener {

            if (index < array.size - 1) {
                index++
                val newData = array[index]
                binding.quoteText.text = newData.text
                binding.quoteAuthor.text = newData.author
            }
        }

        binding.btnprevios.setOnClickListener {
            //0
            if (index > 0) {
                index--
                val previousData = array[index]
                binding.quoteText.text = previousData.text
                binding.quoteAuthor.text = previousData.author
            }
        }

        binding.btnShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, binding.quoteText.text.toString())
            startActivity(Intent.createChooser(intent, "choose one"))
        }
    }
    private fun addQuestDataList() {
        array.add(Model("Iris Murdoch", "We can only learn to love by loving"))
        array.add(Model("Karen Clark", "Life is change. Growth is optional. Choose wisely"))
        array.add(Model("Wayne Dyer", "You'll see it when you believe it"))
        array.add(Model("William Shakespeare", "Having nothing, nothing can he lose."))
        array.add(Model("Iris Murdoch", "We can only learn to love by loving"))
        array.add(Model("Publilius Syrus", "A rolling stone gathers no moss."))
        array.add(Model("Publilius Syrus", "A rolling stone gathers no moss."))
        array.add(Model("Iris Murdoch", "Today is the tomorrow we worried about yesterday"))
        array.add(Model("Naipaul", "The world is always in movement.g"))
        array.add(Model("Haddon Robinson", "What worries you masters you"))
        array.add(Model("Budhha", "He is able who thinks he is able"))
        array.add(Model("Pearl Buck", "One faces the future with ones past."))
        array.add(Model("Brian Tracy", "Goals are the fuel in the furnace of achievement."))
        array.add(Model("Leonardo da Vinci", "Who sows virtue reaps honour"))
        array.add(Model("Chinese proverb", "Talk doesn't cook rice."))


        val myValue = array[index]
        val str: String = myValue.author
        binding.quoteAuthor.text = str

        val str1: String = myValue.text
        binding.quoteText.text = str1

    }

}