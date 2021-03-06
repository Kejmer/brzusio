package com.example.brzusio

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.brzusio.Model.Song

const val DATABASE_NAME = "brzusioDB"
const val TABLE_NAME = "songs"
const val COL_ID = "id"
const val COL_NAME = "title"
const val COL_ARTIST = "artist"

class DbHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(256), " +
                COL_ARTIST + " VARCHAR(256))";
        db?.execSQL(createTable)
        initSongs(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    private fun resultValueToString(result: Long?): String {
        if (result == (-1).toLong())
            return "Failed"
        return "Success"
    }

    private fun insertSong(db : SQLiteDatabase?, song: Song) : Long? {
        val cv = ContentValues()
        cv.put(COL_NAME, song.title)
        cv.put(COL_ARTIST, song.artist)
        return db?.insert(TABLE_NAME, null, cv)
    }

    private fun initSongs(db : SQLiteDatabase?) {
        insertSong(db, Song(0, "Skyfall", "Adele"))
        insertSong(db, Song(0, "W dobrą stronę", "Dawid Podsiadło"))
        insertSong(db, Song(0, "No pokaż na co cię stać", "Feel"))
        insertSong(db, Song(0, "To co nam było", "Red Lips"))
        insertSong(db, Song(0, "Radio hello", "Enej"))
        insertSong(db, Song(0, "Póki na to czas", "De Mono"))
        insertSong(db, Song(0, "Idę na plażę", "Video"))
        insertSong(db, Song(0, "A ja wolę swoją mamę", "Majka Jeżowska"))
        insertSong(db, Song(0, "Californication", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "I will survive", "Gloria Gaynor"))
        insertSong(db, Song(0, "Kiedyś cię znajdę", "Reni Jusis"))
        insertSong(db, Song(0, "Typ niepokorny", "Stachursky"))
        insertSong(db, Song(0, "McDonalds", "Reklama"))
        insertSong(db, Song(0, "Majteczki w kropeczki", "Bayer Full"))
        insertSong(db, Song(0, "Hej Sokoły", "Tomasz Padura"))
        insertSong(db, Song(0, "Help!", "Beatles"))
        insertSong(db, Song(0, "Hey Jude", "Beatles"))
        insertSong(db, Song(0, "Please Mr. Postman", "Beatles"))
        insertSong(db, Song(0, "Yesterday", "Beatles"))
        insertSong(db, Song(0, "I saw her standing there", "Beatles"))
        insertSong(db, Song(0, "Yellow submarine", "Beatles"))
        insertSong(db, Song(0, "Here comes the Sun", "Beatles"))
        insertSong(db, Song(0, "Come together", "Beatles"))
        insertSong(db, Song(0, "Penny Lane", "Beatles"))
        insertSong(db, Song(0, "In my life", "Beatles"))
        insertSong(db, Song(0, "Twist and Shout", "Beatles"))
        insertSong(db, Song(0, "All you need is love", "Beatles"))
        insertSong(db, Song(0, "With a little help of my friends", "Beatles"))
        insertSong(db, Song(0, "Ob-La-Di, Ob-La-Da", "Beatles"))
        insertSong(db, Song(0, "Let it Be", "Beatles"))
        insertSong(db, Song(0, "Sgt. Pepper's Lonely Hearts Club Band", "Beatles"))
        insertSong(db, Song(0, "I want to hold your hand", "Beatles"))
        insertSong(db, Song(0, "Oh! Darling", "Beatles"))
        insertSong(db, Song(0, "Back in the USSR", "Beatles"))
        insertSong(db, Song(0, "All my loving", "Beatles"))
        insertSong(db, Song(0, "When I'm Sixty Four", "Beatles"))
        insertSong(db, Song(0, "Scenariusz dla moich sąsiadów", "Myslovitz"))
        insertSong(db, Song(0, "Jesteś szalona", "Boys"))
        insertSong(db, Song(0, "Wolność", "Boys"))
        insertSong(db, Song(0, "Mydełko Fa", "Marek Kondrat"))
        insertSong(db, Song(0, "Ruda tańczy jak szalona", "Czadoman"))
        insertSong(db, Song(0, "Mój jest ten kawałek podłogi", "Mr. Zoob"))
        insertSong(db, Song(0, "Mówię ci że", "tilt"))
        insertSong(db, Song(0, "Billie Jean", "Michael Jackson"))
        insertSong(db, Song(0, "Scooby Doo", "Czołówka"))
        insertSong(db, Song(0, "Autobiografia", "Perfect"))
        insertSong(db, Song(0, "Przez twe oczy zielone", "Akcent"))
        insertSong(db, Song(0, "Ale ale aleksandra", "Andre"))
        insertSong(db, Song(0, "Rodzina Adamsów", "Czołówka"))
        insertSong(db, Song(0, "Tacy Sami", "Lady Pank"))
        insertSong(db, Song(0, "Nie mogę Ci wiele dać", "Perfekt"))
        insertSong(db, Song(0, "Takie Tango", "Budka Suflera"))
        insertSong(db, Song(0, "Biały miś", "Biesiadne"))
        insertSong(db, Song(0, "My Słowianie", "Donatan, Cleo"))
        insertSong(db, Song(0, "Na Chwile", "Grzegorz Hyży"))
        insertSong(db, Song(0, "Policeman", "Jamal"))
        insertSong(db, Song(0, "Lepszy Model", "Kasia Klich"))
        insertSong(db, Song(0, "Windą do nieba", "Dwa Plus Jeden"))
        insertSong(db, Song(0, "Kobiety są gorące", "Norbi"))
        insertSong(db, Song(0, "Pokolenie", "Kombi"))
        insertSong(db, Song(0, "Na obcy ląd", "Ewelina Lisowska"))
        insertSong(db, Song(0, "W stronę słońca", "Ewelina Lisowska"))
        insertSong(db, Song(0, "Jeden moment", "Pectus"))
        insertSong(db, Song(0, "Pójdę boso", "Zakopower"))
        insertSong(db, Song(0, "Ściernisko", "Golec Uorkiestra"))
        insertSong(db, Song(0, "Testosteron", "Kayah"))
        insertSong(db, Song(0, "Tak smakuje życie", "Enej"))
        insertSong(db, Song(0, "Co z nami będzie", "Sylwia Grzeszczak"))
        insertSong(db, Song(0, "Zakręcona", "Reni Jusis"))
        insertSong(db, Song(0, "Do nieba", "Blue Cafe"))
        insertSong(db, Song(0, "Chan Chan", "Buena Vista Social Club"))
        insertSong(db, Song(0, "Agnieszka", "Łzy"))
        insertSong(db, Song(0, "Czas nie będzie czekał", "Blue Cafe"))
        insertSong(db, Song(0, "Lili", "Enej"))
        insertSong(db, Song(0, "Kamień z napisem love", "Enej"))
        insertSong(db, Song(0, "Skrzydlate ręce", "Enej"))
        insertSong(db, Song(0, "Symetryczno-liryczna", "Enej"))
        insertSong(db, Song(0, "Zbudujemy dom", "Enej"))
        insertSong(db, Song(0, "Dzisiaj będę ja", "Enej"))
        insertSong(db, Song(0, "Bałkanica", "Piersi"))
        insertSong(db, Song(0, "Baśka", "Wilki"))
        insertSong(db, Song(0, "Na zawsze i na wieczność", "Wilki"))
        insertSong(db, Song(0, "Nie stało się nic", "Wilki"))
        insertSong(db, Song(0, "Urke", "Wilki"))
        insertSong(db, Song(0, "Son of the blue sky", "Wilki"))
        insertSong(db, Song(0, "Bohema", "Wilki"))
        insertSong(db, Song(0, "Byłaś dla mnie wszystkim", "Poparzeni kawą trzy"))
        insertSong(db, Song(0, "Okrutna, zła i podła", "Poparzeni kawą trzy"))
        insertSong(db, Song(0, "Kawałek do tańca", "Poparzeni kawą trzy"))
        insertSong(db, Song(0, "Jak anioła głos", "Feel"))
        insertSong(db, Song(0, "Czarne Oczy", "Ivan i Delfin"))
        insertSong(db, Song(0, "Prawy do lewego", "Kayah"))
        insertSong(db, Song(0, "Na językach", "Kayah"))
        insertSong(db, Song(0, "Barcelona", "Pectus"))
        insertSong(db, Song(0, "Dni których nie znamy", "Marek Grechuta"))
        insertSong(db, Song(0, "Nie dokazuj", "Marek Grechuta"))
        insertSong(db, Song(0, "Wiosna, ach to ty", "Marek Grechuta"))
        insertSong(db, Song(0, "A wszystko to…", "Ich troje"))
        insertSong(db, Song(0, "Zawsze z Tobą chciałbym być", "Ich troje"))
        insertSong(db, Song(0, "Babski świat", "Ich troje"))
        insertSong(db, Song(0, "Keine Grenzen", "Ich troje"))
        insertSong(db, Song(0, "Prowadź mnie", "Kasia Kowalska"))
        insertSong(db, Song(0, "Chciałem być", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Mój przyjacielu", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Byle było tak", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Parostatek", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Bo jesteś ty", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Trudno tak", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Abba ojcze", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "To co dał nam świat", "Krzysztof Krawczyk"))
        insertSong(db, Song(0, "Im więcej ciebie tym mniej", "Natalia Kukulska"))
        insertSong(db, Song(0, "Lato", "Formacja Nieżywych Schabuff"))
        insertSong(db, Song(0, "Cyklady na cykladach", "Maanam"))
        insertSong(db, Song(0, "Krakowski spleen", "Maanam"))
        insertSong(db, Song(0, "Kocham cię, kochanie moje", "Maanam"))
        insertSong(db, Song(0, "Szare miraże", "Maanam"))
        insertSong(db, Song(0, "Boskie Buenos", "Maanam"))
        insertSong(db, Song(0, "Lipstick on the glass", "Maanam"))
        insertSong(db, Song(0, "Szał niebieskich ciał", "Maanam"))
        insertSong(db, Song(0, "Nie płacz Ewka", "Perfect"))
        insertSong(db, Song(0, "", ""))
        insertSong(db, Song(0, "Wszystko ma swój czas", "Perfect"))
        insertSong(db, Song(0, "Kołysanka dla nieznajomej", "Perfect"))
        insertSong(db, Song(0, "Chcemy być sobą", "Perfect"))
        insertSong(db, Song(0, "Raz po raz", "Perfect"))
        insertSong(db, Song(0, "Niewiele ci mogę dać", "Perfect"))
        insertSong(db, Song(0, "Niepokonani", "Perfect"))
        insertSong(db, Song(0, "Ale w koło jest wesoło", "Perfect"))
        insertSong(db, Song(0, "Nie daj się zabić", "Perfect"))
        insertSong(db, Song(0, "Zamieniam się w psa", "Perfect"))
        insertSong(db, Song(0, "Facet to świnia", "Big Cyc"))
        insertSong(db, Song(0, "Makumba", "Big Cyc"))
        insertSong(db, Song(0, "Rudy się żeni", "Big Cyc"))
        insertSong(db, Song(0, "Świat według kiepskich", "Czołówka"))
        insertSong(db, Song(0, "Dzieci wybiegły", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Co ty tutaj robisz", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Ona jest pedałem", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Człowiek z liściem", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Wszystko ch.", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Przewróciło", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Jestem z miasta", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Co powie ryba", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Kiler", "Elektryczne Gitary"))
        insertSong(db, Song(0, "Kto powie mi jak", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Dziś późno pójdę spać", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Wzięli zamknęli mi klub", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Wodymidaj", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Turysta", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Niemożliwe", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Chodźmy nad wodę", "Kwiat Jabłoni"))
        insertSong(db, Song(0, "Kryzysowa narzeczona", "Lady Pank"))
        insertSong(db, Song(0, "Tańcz głupia, tańcz", "Lady Pank"))
        insertSong(db, Song(0, "Zamki na piasku", "Lady Pank"))
        insertSong(db, Song(0, "Stacja Warszawa", "Lady Pank"))
        insertSong(db, Song(0, "Na co komu dziś", "Lady Pank"))
        insertSong(db, Song(0, "Zostawcie Titanica", "Lady Pank"))
        insertSong(db, Song(0, "Mniej niż zero", "Lady Pank"))
        insertSong(db, Song(0, "Zawsze tam gdzie ty", "Lady Pank"))
        insertSong(db, Song(0, "Znowu pada deszcz", "Lady Pank"))
        insertSong(db, Song(0, "Czerwone korale", "Brahtanki"))
        insertSong(db, Song(0, "Mamo ja nie chcę za mąż", "Brahtanki"))
        insertSong(db, Song(0, "W kinie w Lublinie", "Brahtanki"))
        insertSong(db, Song(0, "Gdzie ten który powie mi", "Brahtanki"))
        insertSong(db, Song(0, "Gdzie się podziały tamte prywatki", "Wojciech Gąsowski"))
        insertSong(db, Song(0, "10 w skali Beuforta", "Krzysztof Klenczon"))
        insertSong(db, Song(0, "Kocham cię jak Irlandię", "Kobranocka"))
        insertSong(db, Song(0, "Przechyły", "Szanty"))
        insertSong(db, Song(0, "Gdzie ta keja", "Szanty"))
        insertSong(db, Song(0, "Morskie opowieści", "Szanty"))
        insertSong(db, Song(0, "Hiszpańskie dziewczyny", "Szanty"))
        insertSong(db, Song(0, "Bitwa", "Szanty"))
        insertSong(db, Song(0, "Pieśń Wielorybników", "Szanty"))
        insertSong(db, Song(0, "Na Mazury", "Szanty"))
        insertSong(db, Song(0, "Bijatyka", "Szanty"))
        insertSong(db, Song(0, "Marco Polo", "Szanty"))
        insertSong(db, Song(0, "Baranek", "Kult"))
        insertSong(db, Song(0, "Hej czy nie wiecie", "Kult"))
        insertSong(db, Song(0, "Mieszkam w Polsce", "Kult"))
        insertSong(db, Song(0, "Gdy nie ma dzieci", "Kult"))
        insertSong(db, Song(0, "Maria ma syna", "Kult"))
        insertSong(db, Song(0, "Prosto", "Kult"))
        insertSong(db, Song(0, "Brooklyńska rada Żydów", "Kult"))
        insertSong(db, Song(0, "Twój ból jest lepszy niż mój", "Kult"))
        insertSong(db, Song(0, "12 groszy", "Kazik"))
        insertSong(db, Song(0, "Plamy na Słońcu", "Kazik"))
        insertSong(db, Song(0, "O mnie się nie martw", "Katarzyna Sobczyk"))
        insertSong(db, Song(0, "Nogi", "Czarno czarni"))
        insertSong(db, Song(0, "Górą ty", "Golec uOrkiestra"))
        insertSong(db, Song(0, "Crazy is my life", "Golec uOrkiestra"))
        insertSong(db, Song(0, "Pędzą konie", "Golec uOrkiestra"))
        insertSong(db, Song(0, "Lornetka", "Golec uOrkiestra"))
        insertSong(db, Song(0, "Słodycze", "Golec uOrkiestra"))
        insertSong(db, Song(0, "Szarpany", "Golec uOrkiestra"))
        insertSong(db, Song(0, "Orła cień", "Varius Manx"))
        insertSong(db, Song(0, "Chodź pomaluj mój świat", "2 plus 1"))
        insertSong(db, Song(0, "Dumka na dwa serca", "Edyta Górniak"))
        insertSong(db, Song(0, "Słodkiego miłego życia", "Kombi"))
        insertSong(db, Song(0, "Tyle słońca w całym mieście", "Anna Jantar"))
        insertSong(db, Song(0, "Nic nie może wiecznie trwać", "Anna Jantar"))
        insertSong(db, Song(0, "Wsiąść do pociągu byle jakiego", "Maryla Rodowicz"))
        insertSong(db, Song(0, "Piękniejsza", "K.A.S.A"))
        insertSong(db, Song(0, "Cicha woda brzegi rwie", "Zbigniew Kurtycz"))
        insertSong(db, Song(0, "Przeżyj to sam", "Lombard"))
        insertSong(db, Song(0, "Nie bądź taki szybki Bill", "Kasia Sobczyk"))
        insertSong(db, Song(0, "Ciągle pada", "Czerwone Gitary"))
        insertSong(db, Song(0, "Dozwolone od lat 18", "Czerwone Gitary"))
        insertSong(db, Song(0, "Nie zadzieraj nosa", "Czerwone Gitary"))
        insertSong(db, Song(0, "Takie tango", "Budka Suflera"))
        insertSong(db, Song(0, "Jolka", "Budka Suflera"))
        insertSong(db, Song(0, "Bal wszystkich świętych", "Budka Suflera"))
        insertSong(db, Song(0, "Makarena", ""))
        insertSong(db, Song(0, "Zabiorę cię właśnie tam", "Kancelaria"))
        insertSong(db, Song(0, "Wszystko mi mówi że mnie ktoś pokochał", "Skaldowie"))
        insertSong(db, Song(0, "Prześliczna wiolonczelistka", "Skaldowie"))
        insertSong(db, Song(0, "Berlin Zachodni", "Big Cyc"))
        insertSong(db, Song(0, "Ostatnia nocka", "Yugopolis"))
        insertSong(db, Song(0, "Miasto budzi się", "Yugopolis"))
        insertSong(db, Song(0, "Sługi za szlugi", "Yugopolis"))
        insertSong(db, Song(0, "Szparka Sekretarka", "Maryla Rodowicz"))
        insertSong(db, Song(0, "Szklana Pogoda", "Lombard"))
        insertSong(db, Song(0, "Highway to hell", "AC/DC"))
        insertSong(db, Song(0, "Back in black", "AC/DC"))
        insertSong(db, Song(0, "Thunderstruck", "AC/DC"))
        insertSong(db, Song(0, "TNT", "AC/DC"))
        insertSong(db, Song(0, "It's my life", "Bon Jovi"))
        insertSong(db, Song(0, "Livin' on a prayer", "Bon Jovi"))
        insertSong(db, Song(0, "Bohemian Rapsody", "Queen"))
        insertSong(db, Song(0, "We will rock you", "Queen"))
        insertSong(db, Song(0, "Don't stop me now", "Queen"))
        insertSong(db, Song(0, "I want to break free", "Queen"))
        insertSong(db, Song(0, "Another one bites the dust", "Queen"))
        insertSong(db, Song(0, "We are the champions", "Queen"))
        insertSong(db, Song(0, "Somebody to love", "Queen"))
        insertSong(db, Song(0, "The show must go on", "Queen"))
        insertSong(db, Song(0, "Radio Ga Ga", "Queen"))
        insertSong(db, Song(0, "Killer Queen", "Queen"))
        insertSong(db, Song(0, "I want it all", "Queen"))
        insertSong(db, Song(0, "A kind of magic", "Queen"))
        insertSong(db, Song(0, "She's a lady", "Tom Jones"))
        insertSong(db, Song(0, "Wake me up", "Avicii"))
        insertSong(db, Song(0, "Waiting for love", "Avicii"))
        insertSong(db, Song(0, "Hey brothers", "Avicii"))
        insertSong(db, Song(0, "Levels", "Avicii"))
        insertSong(db, Song(0, "Addicted to you", "Avicii"))
        insertSong(db, Song(0, "Be Mine", "Ofenbach"))
        insertSong(db, Song(0, "Rock it", "Ofenbach"))
        insertSong(db, Song(0, "Party", "Ofenbach"))
        insertSong(db, Song(0, "Paradise", "Ofenbach"))
        insertSong(db, Song(0, "Katchi", "Ofenbach"))
        insertSong(db, Song(0, "Call me maybe", "Carly Rae Jepsen"))
        insertSong(db, Song(0, "Gangnam style", "Psy"))
        insertSong(db, Song(0, "Gentleman", "Psy"))
        insertSong(db, Song(0, "Ai Se Eu Te Pego", "Michel Telo"))
        insertSong(db, Song(0, "Bad Romance", "Lady Gaga"))
        insertSong(db, Song(0, "Poker Face", "Lady Gaga"))
        insertSong(db, Song(0, "Alejandro", "Lady Gaga"))
        insertSong(db, Song(0, "Paparazzi", "Lady Gaga"))
        insertSong(db, Song(0, "Born this way", "Lady Gaga"))
        insertSong(db, Song(0, "Applause", "Lady Gaga"))
        insertSong(db, Song(0, "Roar", "Katy Perry"))
        insertSong(db, Song(0, "I kissed a girl", "Katy Perry"))
        insertSong(db, Song(0, "Last Friday Night", "Katy Perry"))
        insertSong(db, Song(0, "Hot n cold", "Katy Perry"))
        insertSong(db, Song(0, "California Gurls", "Katy Perry"))
        insertSong(db, Song(0, "Dancing Queen", "Abba"))
        insertSong(db, Song(0, "Money, money, money", "Abba"))
        insertSong(db, Song(0, "Mamma Mia", "Abba"))
        insertSong(db, Song(0, "Gimmie! Gimmie! Gimmie!", "Abba"))
        insertSong(db, Song(0, "Śmierć w bikini", "Obywatel GC"))
        insertSong(db, Song(0, "Nie pytaj o polskę", "Obywatel GC"))
        insertSong(db, Song(0, "Tak Tak to ja", "Obywatel GC"))
        insertSong(db, Song(0, "Biała flaga", "Republika"))
        insertSong(db, Song(0, "Telefony", "Republika"))
        insertSong(db, Song(0, "Mamona", "Republika"))
        insertSong(db, Song(0, "Barbie girl", "Aqua"))
        insertSong(db, Song(0, "Who let the dogs out", "Baha men"))
        insertSong(db, Song(0, "Toxic", "Britney Spears"))
        insertSong(db, Song(0, "Baby one more time", "Britney Spears"))
        insertSong(db, Song(0, "Oops I did it again", "Britney Spears"))
        insertSong(db, Song(0, "Stronger", "Kanye West"))
        insertSong(db, Song(0, "Power", "Kanye West"))
        insertSong(db, Song(0, "This is America", "Chlidish Gambino"))
        insertSong(db, Song(0, "Bonfire", "Chlidish Gambino"))
        insertSong(db, Song(0, "Redbone", "Chlidish Gambino"))
        insertSong(db, Song(0, "Sweatpants", "Chlidish Gambino"))
        insertSong(db, Song(0, "I feel good", "James Brown"))
        insertSong(db, Song(0, "I belive I can fly", "R. Kelly"))
        insertSong(db, Song(0, "Forever Young", "Alphaville"))
        insertSong(db, Song(0, "Daddy Cool", "Boney M"))
        insertSong(db, Song(0, "Rasputin", "Boney M"))
        insertSong(db, Song(0, "Rivers of Babylon", "Boney M"))
        insertSong(db, Song(0, "Don't worry be happy", "Bobby McFerrin"))
        insertSong(db, Song(0, "Pretty Woman", "Roy Orbinson"))
        insertSong(db, Song(0, "No Woman no cry", "Bob Marley"))
        insertSong(db, Song(0, "Love me tender", "Elvis Presley"))
        insertSong(db, Song(0, "I love Rock n roll", ""))
        insertSong(db, Song(0, "Znamy się tylko z widzenia", "Trubadurzy"))
        insertSong(db, Song(0, "Desperado", "Muzyka z filmu"))
        insertSong(db, Song(0, "Star Wars - Cantina", "Muzyka z filmu"))
        insertSong(db, Song(0, "Star Wars - Intro", "Muzyka z filmu"))
        insertSong(db, Song(0, "Star Wars - Imperial March", "Muzyka z filmu"))
        insertSong(db, Song(0, "Drużyna A", "Czołówka"))
        insertSong(db, Song(0, "Za każdym razem", "Jula"))
        insertSong(db, Song(0, "Jak nie my to kto", "Mrozu"))
        insertSong(db, Song(0, "W dzień gorącego lata", "Big Day"))
        insertSong(db, Song(0, "Bania u cygana", "Zero"))
        insertSong(db, Song(0, "Miał być ślub", "Brodka"))
        insertSong(db, Song(0, "Miałeś być", "Brodka"))
        insertSong(db, Song(0, "Znam cię na pamięć", "Brodka"))
        insertSong(db, Song(0, "Dziewczyna mojego chłopaka", "Brodka"))
        insertSong(db, Song(0, "Granda", "Brodka"))
        insertSong(db, Song(0, "Dancing Shoes", "Brodka"))
        insertSong(db, Song(0, "Wszystko czego dziś chcę", "Izabela Trojanowska"))
        insertSong(db, Song(0, "Świt", "Męskie Granie"))
        insertSong(db, Song(0, "Sobie i Wam", "Męskie Granie"))
        insertSong(db, Song(0, "Nieboskłon", "Męskie Granie"))
        insertSong(db, Song(0, "Wataha", "Męskie Granie"))
        insertSong(db, Song(0, "Elektryczny", "Męskie Granie"))
        insertSong(db, Song(0, "Bela", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Trójkąty i kwadraty", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Najnowszy klip", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Nie ma fal", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Małomiasteczkowy", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Trofea", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Matylda", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Cantate Tutti", "Dawid Podsiadło"))
        insertSong(db, Song(0, "No", "Dawid Podsiadło"))
        insertSong(db, Song(0, "Sen o Przyszłości", "Sylwia Grzeszczak"))
        insertSong(db, Song(0, "Księżniczka", "Sylwia Grzeszczak"))
        insertSong(db, Song(0, "To co nam było", "Red Lips"))
        insertSong(db, Song(0, "Mówią że", "Piotr Rubik"))
        insertSong(db, Song(0, "Hello", "Adele"))
        insertSong(db, Song(0, "Someone like you", "Adele"))
        insertSong(db, Song(0, "Rolling in the deep", "Adele"))
        insertSong(db, Song(0, "Set fire to the rain", "Adele"))
        insertSong(db, Song(0, "Skyfall", "Adele"))
        insertSong(db, Song(0, "Czterdzieści lat minęło", "Andrzej Rosiewicz"))
        insertSong(db, Song(0, "Deszcze niespokojne", ""))
        insertSong(db, Song(0, "M jak Miłość", "Czołówka"))
        insertSong(db, Song(0, "I still haven't found what I'm looking for", ""))
        insertSong(db, Song(0, "Z Archiwum X", ""))
        insertSong(db, Song(0, "Nie daj mi odejść", "Ira"))
        insertSong(db, Song(0, "Benny Hill", ""))
        insertSong(db, Song(0, "Cool me down", "Margaret"))
        insertSong(db, Song(0, "Heartbeat", "Margaret"))
        insertSong(db, Song(0, "Thank you very much", "Margaret"))
        insertSong(db, Song(0, "Reksiu", "Margaret"))
        insertSong(db, Song(0, "Mam tę moc", "Kraina lodu"))
        insertSong(db, Song(0, "I see fire", "Ed Sheeran"))
        insertSong(db, Song(0, "Małe rzeczy", "Sylwia Grzeszczak"))
        insertSong(db, Song(0, "Nothing Else Matters", "Metallica"))
        insertSong(db, Song(0, "Somebody that I used to know", "Gotye"))
        insertSong(db, Song(0, "Not Afraid", "Eminem"))
        insertSong(db, Song(0, "Counting Stars", "OneRepublic"))
        insertSong(db, Song(0, "Ewakuacja", "Ewa Farna"))
        insertSong(db, Song(0, "Castle of Glass", "Linkin Park"))
        insertSong(db, Song(0, "Last Christmas", "Wham!"))
        insertSong(db, Song(0, "Lonely Day", "System Of A Down"))
        insertSong(db, Song(0, "Chop Suey", "System Of A Down"))
        insertSong(db, Song(0, "Hallelujah", "Leonard Cohen"))
        insertSong(db, Song(0, "Pożyczony", "Sylwia Grzeszczak"))
        insertSong(db, Song(0, "Naucz mnie", "Sarsa"))
        insertSong(db, Song(0, "The Sound of Silence", "Simon & Garfunkel"))
        insertSong(db, Song(0, "Homeward Bound", "Simon & Garfunkel"))
        insertSong(db, Song(0, "Gdybym miał gitarę", "Bayer Full"))
        insertSong(db, Song(0, "Wszystko się może zdarzyć", "Anita Lipnicka"))
        insertSong(db, Song(0, "Wschód", "Bedoes"))
        insertSong(db, Song(0, "Ostatnia Niedziela", "Mieczysław Fogg"))
        insertSong(db, Song(0, "Can't stop", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "Californication", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "Dani California", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "Otherside", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "Under the bridge", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "Szczęśliwej drogi już czas", "Ryszard Rynkowski"))
        insertSong(db, Song(0, "Nie liczę godzin i lat", "Ryszard Rynkowski"))
        insertSong(db, Song(0, "Niech żyje bal", "Maryla Rodowicz"))
        insertSong(db, Song(0, "Narcyz", "Łzy"))
        insertSong(db, Song(0, "Łatwopalni", "Maryla Rodowicz"))
        insertSong(db, Song(0, "Każdego dnia", "Mesajah"))
        insertSong(db, Song(0, "Dziwny jest ten świat", "Czesław Niemen"))
        insertSong(db, Song(0, "Sen o Warszawie", "Czesław Niemen"))
        insertSong(db, Song(0, "Dres", "Big Cyc"))
        insertSong(db, Song(0, "Black and White", "Michael Jackson"))
        insertSong(db, Song(0, "Bo tutaj jest jak jest", "Paweł Kukiz"))
        insertSong(db, Song(0, "Całuj mnie", "Paweł Kukiz"))
        insertSong(db, Song(0, "Chłopaki nie płaczą", "T.Love"))
        insertSong(db, Song(0, "Nie nie nie", "T.Love"))
        insertSong(db, Song(0, "Ajrisz", "T.Love"))
        insertSong(db, Song(0, "King", "T.Love"))
        insertSong(db, Song(0, "Warszawa", "T.Love"))
        insertSong(db, Song(0, "Bo z Dziewczynami", "Jerzy Polomski"))
        insertSong(db, Song(0, "Brunetki, blondynki", "Jan Kiepura"))
        insertSong(db, Song(0, "Bądź duży", "Natalia Nykiel"))
        insertSong(db, Song(0, "Awinion", "Kobii"))
        insertSong(db, Song(0, "What Makes You Beautiful", "One Direction"))
        insertSong(db, Song(0, "Story of My Life", "One Direction"))
        insertSong(db, Song(0, "One Way Or Another", "One Direction"))
        insertSong(db, Song(0, "Back to Black", "Amy Winehouse"))
        insertSong(db, Song(0, "Rehab", "Amy Winehouse"))
        insertSong(db, Song(0, "Summer Nights", "Grease"))
        insertSong(db, Song(0, "Sweet Home Alabama", "Lynyrd Skynyrd"))
        insertSong(db, Song(0, "La Bamba", ""))
        insertSong(db, Song(0, "Samba de Janeiro", ""))
        insertSong(db, Song(0, "Ice ice baby", "Vanilia Ice"))
        insertSong(db, Song(0, "Wake me up before you go-go", "Wham!"))
        insertSong(db, Song(0, "Stand By Me", "Ben E. King"))
        insertSong(db, Song(0, "Koko koko euro spoko", "Jarzębina"))
        insertSong(db, Song(0, "Born to be wild", "Steppenwolf"))
        insertSong(db, Song(0, "Tańczyć chcę", "Long & Junior"))
        insertSong(db, Song(0, "Bob budowniczy", ""))
        insertSong(db, Song(0, "Cztery osiemnastki", "Tomasz Niecik"))
        insertSong(db, Song(0, "Love Story", "Wilki"))
        insertSong(db, Song(0, "Piękna i Młoda", "TOMO"))
        insertSong(db, Song(0, "Moje bieszczady", "KSU"))
        insertSong(db, Song(0, "Długość dźwięku samotności", "Myslovitz"))
        insertSong(db, Song(0, "Z twarzą Marylin Monroe", "Myslovitz"))
        insertSong(db, Song(0, "Papieros", "Video"))
        insertSong(db, Song(0, "Idę na plażę", "Video"))
        insertSong(db, Song(0, "Bella", "Video"))
        insertSong(db, Song(0, "Środa Czwartek", "Video"))
        insertSong(db, Song(0, "Wszystko jedno", "Video"))
        insertSong(db, Song(0, "Ktoś nowy", "Video"))
        insertSong(db, Song(0, "No pokaż na co cię stać", "Feel"))
        insertSong(db, Song(0, "Lepsza połowa", "Mesajah"))
        insertSong(db, Song(0, "Moherowe Berety", "Big Cyc"))
        insertSong(db, Song(0, "Hakuna Matata", "Król Lew"))
        insertSong(db, Song(0, "W Aucie", "Sokół"))
        insertSong(db, Song(0, "Już taki jestem zimny drań", "Mieczysław Fogg"))
        insertSong(db, Song(0, "King Bruce Lee", "Franek Kimono"))
        insertSong(db, Song(0, "Aniele mój", "Łzy"))
        insertSong(db, Song(0, "Oczy szeroko zamknięte", "Łzy"))
        insertSong(db, Song(0, "Anka od tak", "Łzy"))
        insertSong(db, Song(0, "Skuter", "Sidney Polak"))
        insertSong(db, Song(0, "Otwieram wino", "Sidney Polak"))
        insertSong(db, Song(0, "Byłem tam", "Sidney Polak"))
        insertSong(db, Song(0, "2 Bajki", "Virgin"))
        insertSong(db, Song(0, "Dzaga", "Virgin"))
        insertSong(db, Song(0, "Szanca", "Virgin"))
        insertSong(db, Song(0, "Nie daj się", "Doda"))
        insertSong(db, Song(0, "Lubiła Tańczyć", "Rotary"))
        insertSong(db, Song(0, "Jeszcze raz", "Patrycja Markowska"))
        insertSong(db, Song(0, "Żałuję", "Ewelina Flinta"))
        insertSong(db, Song(0, "Napraw", "LemON"))
        insertSong(db, Song(0, "Na kolana", "Kasia Cerekwicka"))
        insertSong(db, Song(0, "Załoga G", "Hurt"))
        insertSong(db, Song(0, "To my polacy", "52 Dębiec"))
        insertSong(db, Song(0, "Dzień dobry, kocham cię", "Strachy na lachy"))
        insertSong(db, Song(0, "Czarny chleb i czarna kawa", "Strachy na lachy"))
        insertSong(db, Song(0, "Twoje oczy lubią mnie", "Strachy na lachy"))
        insertSong(db, Song(0, "Raissa", "Strachy na lachy"))
        insertSong(db, Song(0, "Megiera", "Sławomir"))
        insertSong(db, Song(0, "Halo", "Beyonce"))
        insertSong(db, Song(0, "Single Ladies", "Beyonce"))
        insertSong(db, Song(0, "Forever Young", "Alphaville"))
        insertSong(db, Song(0, "Trzy Życzenia", "Bas Tajpan"))
        insertSong(db, Song(0, "What a wonderful world", "Louis Armstrong"))
        insertSong(db, Song(0, "Danza Koduro", "Lucenzo"))
        insertSong(db, Song(0, "Every breath you take", "The Police"))
        insertSong(db, Song(0, "How you remind me", "Nickelback"))
        insertSong(db, Song(0, "Blurred Lines", "Robin Thicke"))
        insertSong(db, Song(0, "Numb", "Linkin Park"))
        insertSong(db, Song(0, "Radioactive", "Imagine Dragons"))
        insertSong(db, Song(0, "Changes", "2Pac"))
        insertSong(db, Song(0, "Bring me to life", "Evanescence"))
        insertSong(db, Song(0, "Stronger", "Kelly Clarkson"))
        insertSong(db, Song(0, "Niemiłość", "Organek"))
        insertSong(db, Song(0, "Wiosna", "Organek"))
        insertSong(db, Song(0, "Pogo", "Organek"))
        insertSong(db, Song(0, "O matko", "Organek"))
        insertSong(db, Song(0, "Ultimo", "Organek"))
        insertSong(db, Song(0, "Mississippi w ogniu", "Organek"))
        insertSong(db, Song(0, "99 Luftballons", "Nena"))
        insertSong(db, Song(0, "Come on Eileen", "Dexyx Midnight Runners"))
        insertSong(db, Song(0, "ta piosenka nie jest smutna", "Prometh"))
        insertSong(db, Song(0, "Just the two of us", "Grover Washington"))
        insertSong(db, Song(0, "Mięso", "Taco Hemingway"))
        insertSong(db, Song(0, "Szlugi i Kalafiory", "Taco Hemingway"))
        insertSong(db, Song(0, "Polskie Tango", "Taco Hemingway"))
        insertSong(db, Song(0, "Marsz, Marsz", "Taco Hemingway"))
        insertSong(db, Song(0, "Białkoholicy", "Taco Hemingway"))
        insertSong(db, Song(0, "6 zer", "Taco Hemingway"))
        insertSong(db, Song(0, "Następna stacja", "Taco Hemingway"))
        insertSong(db, Song(0, "Ruby", "Kaiser Chiefs"))
        insertSong(db, Song(0, "That's not my name", "The Tings"))
        insertSong(db, Song(0, "Zombie", "Jamie T"))
        insertSong(db, Song(0, "Chelsea Dagger", "The Fratellis"))
        insertSong(db, Song(0, "Home", "Edward Sharpe"))
        insertSong(db, Song(0, "Smile", "Lily Allen"))
        insertSong(db, Song(0, "LDN", "Lily Allen"))
        insertSong(db, Song(0, "Dog Days Are Over", "Florence + The Machine"))
        insertSong(db, Song(0, "Shake it Out", "Florence + The Machine"))
        insertSong(db, Song(0, "Look what you made me do", "Taylor Swift"))
        insertSong(db, Song(0, "Shake it Off", "Taylor Swift"))
        insertSong(db, Song(0, "Lost on you", "LP"))
        insertSong(db, Song(0, "Mandarynki", "Kamil Pivot"))
        insertSong(db, Song(0, "I think I'm gonna kill myself", "Elton John"))
        insertSong(db, Song(0, "I'm still standing", "Elton John"))
        insertSong(db, Song(0, "Spalona Grzała", "Es & Ex"))
        insertSong(db, Song(0, "Hi-Fi", "Wanda i Banda"))
        insertSong(db, Song(0, "American Pie", "Don McLean"))
        insertSong(db, Song(0, "Kapslami w niebo", "Pull the wire"))
        insertSong(db, Song(0, "Dude (looks like a lady)", "Aerosmith"))
        insertSong(db, Song(0, "Stuck in the middle with you", "Stealers Wheel"))
        insertSong(db, Song(0, "Stray Cats Strut", "Stray Cats"))

    }

    private fun selectSongs(query : String) : MutableList<Song> {
        val list : MutableList<Song> = ArrayList()

        val db = this.readableDatabase
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val song = Song(
                    result.getInt(result.getColumnIndex(COL_ID)),
                    result.getString(result.getColumnIndex(COL_NAME)),
                    result.getString(result.getColumnIndex(COL_ARTIST))
                );
                list.add(song)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun randomSongs() : MutableList<Song> {
        return selectSongs("SELECT * FROM $TABLE_NAME ORDER BY RANDOM() LIMIT 10")
    }

    fun allSongs() : MutableList<Song> {
        return selectSongs("SELECT * FROM $TABLE_NAME ORDER BY $COL_ARTIST, $COL_NAME COLLATE NOCASE ASC")
    }

    fun deleteSong(song: Song) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(song.id.toString()))
        db.close()
    }

    fun addSong(song: Song) {
        val db = this.writableDatabase
        val result = insertSong(db, song)
        Toast.makeText(context, resultValueToString(result), Toast.LENGTH_SHORT).show()
        db.close()
    }
}