package com.example.simplemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Menu1 : AppCompatActivity() {

    private lateinit var menuContainer: LinearLayout
    private lateinit var detailTitle: TextView
    private lateinit var detailDescription: TextView
    private lateinit var detailPrice: TextView

    // Data 10 menu
    private val menuList = listOf(
        Menu("Red Velvet Cheesecake", "Kombinasi red velvet yang moist dengan creamy cheesecake. Penampilan menarik dengan rasa yang memanjakan lidah", "Rp. 32.000,00"),
        Menu("Premium Fudgy Brownies", "Brownies lembut dengan lapisan cokelat pekat dan topping yang meleleh. Cocok untuk pecinta cokelat", "Rp. 28.000,00"),
        Menu("Lotus Cheesecake", "Cheesecake yang lembut dengan lelehan sauce Lotus Biscuit yang manis dan gurih. Setiap gigitan terasa premium", "Rp. 35.000,00"),
        Menu("Dark Chocolate Layer Cake", "Kue cokelat yang pekat dengan lapisan ganache lembut. Cita rasa intens yang cocok untuk pecinta cokelat sejati", "Rp. 34.000,00"),
        Menu("Black Forest Cheesecake", "Perpaduan krim lembut dan lapisan cokelat dengan topping ceri segar yang manis dan menggoda", "Rp. 34.000,00"),
        Menu("Kiwi Cheesecake", "Cheesecake creamy dengan lapisan segar buah kiwi. Dengan perpaduan asam manis yang menyegarkan", "Rp. 30.000,00"),
        Menu("Oreo Cheesecake", "Perpaduan krim keju yang lembut dan potongan biskuit Oreo yang renyah. Favorit sepanjang masa", "Rp. 32.000,00"),
        Menu("Blueberry Cheesecake", "Cheesecake lembut dengan lapisan blueberry segar dan aroma manis yang khas", "Rp. 33.000,00"),
        Menu("Strawberry Cheesecake", "Kue keju dengan lapisan selai strawberry dan potongan buah segar. Segar dan manis alami", "Rp. 32.000,00"),
        Menu("Fresh Fruit Sandwich", "Roti lembut isi krim segar dan potongan buah-buahan manis yang menyegarkan", "Rp. 25.000,00")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)

        initViews()
        setupMenu()
    }

    private fun initViews() {
        menuContainer = findViewById(R.id.menuContainer)
        detailTitle = findViewById(R.id.detailTitle)
        detailDescription = findViewById(R.id.detailDescription)
        detailPrice = findViewById(R.id.detailPrice)
    }

    private fun setupMenu() {
        val inflater = LayoutInflater.from(this)

        for (menu in menuList) {
            val menuView = inflater.inflate(R.layout.item_menu, menuContainer, false)

            val menuName = menuView.findViewById<TextView>(R.id.menuName)
            val menuPrice = menuView.findViewById<TextView>(R.id.menuPrice)

            menuName.text = menu.name
            menuPrice.text = menu.price

            menuView.setOnClickListener {
                showMenuDetail(menu)
                setSelectedMenu(menuView)
            }

            menuContainer.addView(menuView)
        }
    }

    private fun showMenuDetail(menu: Menu) {
        detailTitle.text = menu.name
        detailDescription.text = menu.description
        detailPrice.text = menu.price
    }

    private fun setSelectedMenu(selectedView: View) {
        // Reset background semua menu
        for (i in 0 until menuContainer.childCount) {
            val child = menuContainer.getChildAt(i)
            child.setBackgroundColor(0x00000000) // Transparent
        }

        // Set background untuk menu yang dipilih
        selectedView.setBackgroundColor(0x1AE91E63) // Light pink
    }

    data class Menu(
        val name: String,
        val description: String,
        val price: String
    )
}