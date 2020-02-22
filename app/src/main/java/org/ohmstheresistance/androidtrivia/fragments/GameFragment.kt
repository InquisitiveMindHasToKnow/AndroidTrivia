package org.ohmstheresistance.androidtrivia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import org.ohmstheresistance.androidtrivia.R
import org.ohmstheresistance.androidtrivia.databinding.GameFragmentBinding
import kotlin.math.min

class GameFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")),
        Question(text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")),
        Question(text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onActivityCreated", "onCreateLayout", "onInflateLayout")),
        Question(text = "Build system for Android?",
            answers = listOf("Gradle", "Grapple", "Groovy", "Groyle")),
        Question(text = "Android vector format?",
            answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
        Question(text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
        Question(text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
        Question(text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")),
        Question(text= "What is ANR?",
            answers = listOf("Application Not Responding", "Android Needs Restarting", "Android Notification Removal", "Application Needs Refreshing")),
        Question(text = "Which of these is NOT an access modifier?",
            answers = listOf("primitive", "public", "private", "protected")),
        Question(text= "Where are activities declared so the system can access them?",
            answers = listOf("manifest", "fragment", "menu", "layout")),
        Question(text = "What is an Array used for?",
            answers = listOf("Arrays are used to store multiple values in a single variable.", "Arrays are used to store key value pairs.",
                "Arrays are used to connect to the internet easily.", "Arrays are used to set text to views.")),
        Question(text = "What is a HashMap?",
            answers = listOf("A HashMap is a collection class that is used for storing key/value pairs", "A HashMap is a primitive data type.",
                "A HashMap is an ordered collection.", "A HashMap is a mutable sequence of characters.")),
        Question(text= "What is the difference between an int and a long?",
            answers = listOf("An int is a 32-bit number and a long is a 64-bit number.", "An int is a 64-bit number and a long is a 32-bit number.",
                "An int is a 8-bit number and a long is a 16-bit number.", "An int is a 16-bit number and a long is a 8-bit number.")),
        Question(text = "What is the difference between a val and var declaration?",
            answers = listOf("val variables cannot be changed. They’re like final modifiers in Java. A var can be reassigned.", "var variables cannot be changed. They’re like final modifiers in Java. A val can be reassigned.",
                "val variables are the same as var variables.", "val variables are always null, var variables are never null.")),
        Question(text = "What are the android app components?",
            answers = listOf("Activities, Services, Broadcast receivers, Content providers", "Manifest, Context, Garbage Collection, Variables",
                "Arrays, Integers, HashSets, Data Binding", "Context, Application, Layout, Drawables")),
        Question(text = "What is context?",
            answers = listOf("Context is the current state of the application/object", "Context is what we use to start new activities",
                "Context handles orientation changes in applications", "Context stores all activity and fragment layouts of an app.")),
        Question(text = "What is an Activity?",
            answers = listOf("An activity provides the window in which the app draws its UI.", "An activity is a menu that displays options.",
                "An activity  is a build tool that Android Studio and Android Gradle Plugin use to compile and package your app’s resources.",
                "An activity is irrelevant to Android.")),
        Question(text = "What is AAPT? (Android Asset Packaging Tool)",
            answers = listOf("a build tool that Android Studio and Android Gradle Plugin use to compile and package your app’s resources.",
                "a packaging tool to organize android libraries.", "a tool for garbage collection and freeing up memory.",
                "a tool that stores all application variables.")),
        Question(text = "What is a Service?",
            answers = listOf("A service is a component which doesn't have UI and can perform long running operations like downloading stuff, playing music etc",
                "A kind of message or information that is passed to the components", "a component that provides the ability to launch an activity based not only on an explicit request",
                        "a component responsible for being the the middle man between a View and Model")),
        Question(text = "The xml file that holds all the text of the application is: ",
            answers = listOf("strings.xml", "drawables.xml", "texts.xml", "layouts.xml")),
        Question(text= "What runs in the background and doesn't have any UI components?",
            answers = listOf("Services", "Activities", "Intents", "Content Providers")),
        Question(text = "When an activity doesn't exist in memory it is in:",
            answers = listOf("Starting state", "Loading state", "Invisible state", "Running state")),
        Question(text = "Which of the following is the most \"resource hungry\" part of dealing with Activities on Android?",
            answers = listOf("Opening a new app", "Closing an app", "Suspending an app", "Restoring the most recent app")),
        Question(text = "In Kotlin, classes are ______ by default, meaning they cannot be inherited from",
            answers = listOf("Final", "Public", "Open", "Protected")),
        Question(text = "To allow inheritance on a class, use the ______ keyword.",
            answers = listOf("Open", "Returnable", "Inheritable", "Public Class")),
        Question(text = "This type of class is open by default:",
            answers = listOf("All of These", "Interfaces", "Abstract Classes", "Sealed Classes")),
        Question(text = "The public visibility modifier means:",
            answers = listOf("This can be accessed from anywhere.", "This can only be accessed from the class defining it and any derived classes.", "This can only be accessed from the module code.", "This can only be accessed from the scope of the class defining it.")),
        Question(text = "The internal visibility modifier means:",
            answers = listOf("This can only be accessed from the scope of the class defining it.", "This can be accessed from anywhere.", "This can only be accessed from the module code.", "This can only be accessed from the class defining it and any derived classes.")),
        Question(text = "The protected visibility modifier means:",
            answers = listOf("This can only be accessed from the class defining it and any derived classes.", "This can only be accessed from the scope of the class defining it.", "This can be accessed from anywhere.", "This can only be accessed from the module code.")),
        Question(text = "The private visibility modifier means:",
            answers = listOf("This can only be accessed from the module code.", "This can only be accessed from the class defining it and any derived classes.", "This can only be accessed from the scope of the class defining it.", "This can be accessed from anywhere.")),
        Question(text = "What is Reflection?",
            answers = listOf("A language's ability to inspect code at runtime instead of compile time.", "A language's ability to inspect code at compile time instead of runtime.", "None of these", "An language's ability to copy code without compiling.")),
        Question(text = "Which of these is used to handle null exceptions in Kotlin?",
            answers = listOf("The Elvis Operator", "Range", "Sealed Class", "Lambdas")),
        Question(text = " What are high order functions?",
            answers = listOf("High order functions consider functions as a parameter and produce a function.", "Higher order functions allow null objects by default.", "Higher order functions are the opposite or Lower order functions.", "All of these"))


    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = min((questions.size + 1) / 2, 10)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<GameFragmentBinding>(
            inflater, R.layout.game_fragment, container, false)

        randomizeQuestions()

        binding.game = this
        binding.questionRadioGroup.clearCheck()

        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++

                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {

                        //view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
                        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(questionIndex, numQuestions))
                    }
                } else {

                    //view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                    view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(questionIndex, numQuestions))
                }

                binding.questionRadioGroup.clearCheck()
                view.clearAnimation()
            }
        }
        return binding.root
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]

        answers = currentQuestion.answers.toMutableList()

        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }
}
