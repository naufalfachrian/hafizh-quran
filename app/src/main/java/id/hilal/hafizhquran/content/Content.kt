package id.hilal.hafizhquran.content

import android.graphics.Path
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.*

var content: ArrayList<Surah> = ArrayList<Surah>()

fun initContent() {
    // AL-Fatihah
    val fatihah  = ArrayList<Ayah>()
    fatihah.add(Ayah("بِسْمِ الِلّٰهِ الرَّحْمٰنِ الرَّحِيْمِ", R.raw.bismillah))
    fatihah.add(Ayah("اَالْحَمْدُ لِلّٰهِ رَبِّ الْعٰلَمِيْنَ", R.raw.al_fatihah_2))
    fatihah.add(Ayah("اَلرَّحْمٰنِ الرَّحِيْمِ", R.raw.al_fatihah_3))
    fatihah.add(Ayah("مٰلِكِ يَوْمِ الدِّيْنِ", R.raw.al_fatihah_4))
    fatihah.add(Ayah("اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْنُ", R.raw.al_fatihah_5))
    fatihah.add(Ayah("اِهْدِنَا الصِّرَاطَ الْمُسْتَقِيْمَ", R.raw.al_fatihah_6))
    fatihah.add(Ayah("صِرَاطَ الَّذِ يْنَ اَنْعَمْتَ عَلَيْهِمْ ۙ غَيْرِ ٱلْمَغْضُوْبِ عَلَيْهِمْ وَلاَ ٱلضَّآلِّيْنَ", R.raw.al_fatihah_7))
    // An-Naas
    val an_naas = ArrayList<Ayah>()
    an_naas.add(Ayah("بِسْمِ الِلّٰهِ الرَّحْمٰنِ الرَّحِيْمِ", R.raw.bismillah))
    an_naas.add(Ayah("قُلْ أَعُوذُ بِرَبِّ النَّاسِ", R.raw.an_naas_1))
    an_naas.add(Ayah("مَلِكِ النَّاسِ", R.raw.an_naas_2))
    an_naas.add(Ayah("إِلَهِ النَّاسِ", R.raw.an_naas_3))
    an_naas.add(Ayah("مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ", R.raw.an_naas_4))
    an_naas.add(Ayah("الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ", R.raw.an_naas_5))
    an_naas.add(Ayah("مِنَ الْجِنَّةِ وَالنَّاسِ", R.raw.an_naas_6))
    // Al-Lahab
    val al_lahab = ArrayList<Ayah>()
    al_lahab.add(Ayah("بِسْمِ الِلّٰهِ الرَّحْمٰنِ الرَّحِيْمِ", R.raw.bismillah))
    al_lahab.add(Ayah("تَبَّتۡ يَدَاۤ اَبِىۡ لَهَبٍ وَّتَبَّؕ ", R.raw.al_lahab_1))
    al_lahab.add(Ayah("مَاۤ اَغۡنٰى عَنۡهُ مَالُهٗ وَمَا كَسَبَؕ", R.raw.al_lahab_2))
    al_lahab.add(Ayah("سَيَصۡلٰى نَارًا ذَاتَ لَهَبٍ", R.raw.al_lahab_3))
    al_lahab.add(Ayah("وَّامۡرَاَ تُهٗ ؕ حَمَّالَةَ الۡحَطَبِ", R.raw.al_lahab_4))
    al_lahab.add(Ayah("فِىۡ جِيۡدِهَا حَبۡلٌ مِّنۡ مَّسَدٍ", R.raw.al_lahab_5))
    // Al-Ikhlas
    val al_ikhlas = ArrayList<Ayah>()
    al_ikhlas.add(Ayah("بِسْمِ الِلّٰهِ الرَّحْمٰنِ الرَّحِيْمِ", R.raw.bismillah))
    al_ikhlas.add(Ayah("قُلۡ هُوَ اللّٰهُ اَحَدٌ", R.raw.al_ikhlas_1))
    al_ikhlas.add(Ayah("اَللّٰهُ الصَّمَدُ", R.raw.al_ikhlas_2))
    al_ikhlas.add(Ayah("لَمۡ يَلِدۡ  ۙوَلَمۡ يُوۡلَدۡ", R.raw.al_ikhlas_3))
    al_ikhlas.add(Ayah("وَلَمۡ يَكُنۡ لَّهٗ كُفُوًا اَحَدٌ", R.raw.al_ikhlas_4))
    // Al-Falaq
    val al_falaq = ArrayList<Ayah>()
    al_falaq.add(Ayah("بِسْمِ الِلّٰهِ الرَّحْمٰنِ الرَّحِيْمِ", R.raw.bismillah))
    al_falaq.add(Ayah("قُلۡ اَعُوۡذُ بِرَبِّ الۡفَلَقِۙ", R.raw.al_falaq_1))
    al_falaq.add(Ayah("مِنۡ شَرِّ مَا خَلَقَۙ", R.raw.al_falaq_2))
    al_falaq.add(Ayah("وَمِنۡ شَرِّ غَاسِقٍ اِذَا وَقَبَۙ", R.raw.al_falaq_3))
    al_falaq.add(Ayah("وَمِنۡ شَرِّ النَّفّٰثٰتِ فِى الۡعُقَدِ", R.raw.al_falaq_4))
    al_falaq.add(Ayah("وَمِنۡ شَرِّ حَاسِدٍ اِذَا حَسَدَ", R.raw.al_falaq_5))

    // test for al-fatihah
    val fatihah_1 = Question("Bacakan ayat ketiga surat al fatihah", null,
            "arrohmaanirrohim", QuestionType.Audio)
    val fatihah_2 = Question("اِيَّاكَ نَعۡبُدُ وَاِيَّاكَ نَسۡتَعِيۡنُؕ  Apa lanjutan ayat tersebut",
            listOf(
                    Option("مٰلِكِ يَوۡمِ الدِّيۡنِؕ", false),
                    Option("اِهۡدِنَا الصِّرَاطَ الۡمُسۡتَقِيۡمَۙ", true),
                    Option("صِرَاطَ الَّذِيۡنَ اَنۡعَمۡتَ عَلَيۡهِمۡ ۙغَيۡرِ الۡمَغۡضُوۡبِ عَلَيۡهِمۡ وَلَا الضَّآلِّيۡنَ", false)),
            null, QuestionType.MultipleChoice)
    val fatihah_3 = Question("bacakan bunyi ayat keempat surat al fatihah", null,
            "malikiyaumiddin", QuestionType.Audio)
    val fatihah_4 = Question("اِهۡدِنَا الصِّرَاطَ الۡمُسۡتَقِيۡمَۙ ayat tersebut merupakan potongan ayat ke-?",
            listOf(
                    Option("5", false),
                    Option("6", true),
                    Option("7", false)),
            null, QuestionType.MultipleChoice)

    // test for an-naas
    val naas_1 = Question("Bacakan ayat pertama surat An Naas", null,
            "Qul A’udzu birabbinnas", QuestionType.Audio)
    val naas_2 = Question("مِنۡ شَرِّ الۡوَسۡوَاسِالۡخَـنَّاسِ Manakah ayat dibawah ini yang menunjukkan 2 ayat setelah ayat tersebut?",
            listOf(
                    Option("اِلٰهِ النَّاسِۙ", false),
                    Option("الَّذِىۡ يُوَسۡوِسُ فِىۡ صُدُوۡرِ النَّاسِۙ", false),
                    Option("مِنَ الۡجِنَّةِ وَالنَّاسِ", true)),
            null, QuestionType.MultipleChoice)
    val naas_3 = Question("Bacakan ayat ketiga surat An Naas.", null,
            "ilahinas", QuestionType.Audio)
    val naas_4 = Question("Berapa jumlah ayat surat An Naas?",
            listOf(
                    Option("6", true),
                    Option("7", false),
                    Option("5", false)),
            null, QuestionType.MultipleChoice)

    // test for an-falaq
    val falaq_1 = Question("Bacakan surat pertama surat Al Falaq", null,
            "Qul a'udzu birabbil falaq", QuestionType.Audio)
    val falaq_2 = Question("Berapa jumlah ayat surat al falaq?",
            listOf(
                    Option("4", false),
                    Option("5", true),
                    Option("6", false)),
            null, QuestionType.MultipleChoice)
    val falaq_3 = Question("Bacakan ayat kedua surat al falaq.", null,
            "min syarri maa kholaq", QuestionType.Audio)
    val falaq_4 = Question("Manakah ayat dibawah ini yang merupakan ayat terakhir surat al falaq?",
            listOf(
                    Option("وَمِنۡ شَرِّ النَّفّٰثٰتِ فِى الۡعُقَدِۙ", false),
                    Option("وَمِنۡ شَرِّ غَاسِقٍ اِذَا وَقَبَۙ", false),
                    Option("وَمِنۡ شَرِّ حَاسِدٍ اِذَا حَسَدَ", true)),
            null, QuestionType.MultipleChoice)

    // test for al-ikhlas
    val ikhlas_1 = Question("Bacakan Ayat pertama surat al ikhlas.", null,
            "Qul Huwallahu Ahad", QuestionType.Audio)
    val ikhlas_2 = Question("اَللّٰهُ الصَّمَدُ ۚ Apa bunyi ayat setelah ayat tersebut?",
            listOf(
                    Option("لَمۡ يَلِدۡوَلَمۡ يُوۡلَدۡ", true),
                    Option("قُلۡ هُوَ اللّٰهُ اَحَدٌ", false),
                    Option("وَلَمۡ يَكُنۡ لَّهٗ كُفُوًا اَحَدٌ", false)),
            null, QuestionType.MultipleChoice)
    val ikhlas_3 = Question("Bacakan ayat ketiga surat al ikhlas.", null,
            "lam yalid walam yulad", QuestionType.Audio)
    val ikhlas_4 = Question("Apa bunyi ayat terakhir surat al ikhlas?",
            listOf(
                    Option("اَللّٰهُ الصَّمَدُ", false),
                    Option("لَمۡ يَلِدۡ وَلَمۡ يُوۡلَدۡ", false),
                    Option("وَلَمۡ يَكُنۡ لَّهٗ كُفُوًا اَحَدٌ", true)),
            null, QuestionType.MultipleChoice)

    // test for al-lahab
    val lahab_1 = Question("Bacakan ayat pertama surat al lahab.", null,
            "tabbat yada abi lahabiyuwwatab", QuestionType.Audio)
    val lahab_2 = Question("Apa lanjutan dari dari ayat berikut وَّامۡرَاَ تُهٗ ؕ حَمَّالَةَ الۡحَطَبِۚ ?",
            listOf(
                    Option("فِىۡ جِيۡدِهَا حَبۡلٌ مِّنۡ مَّسَدٍ", true),
                    Option("مَاۤ اَغۡنٰى عَنۡهُ مَالُهٗ وَمَا كَسَبَؕ", false),
                    Option("سَيَصۡلٰى نَارًا ذَاتَ لَهَبٍ", false)),
            null, QuestionType.MultipleChoice)
    val lahab_3 = Question("Bacakan Ayat terakhir surat al lahab", null,
            "fijidiha hablum mim Masad", QuestionType.Audio)
    val lahab_4 = Question("Apa bunyi 2 ayat sebelum ayat berikut فِىۡ جِيۡدِهَا حَبۡلٌ مِّنۡ مَّسَدٍ ?",
            listOf(
                    Option("وَّامۡرَاَ تُهٗ ؕ حَمَّالَةَ الۡحَطَبِۚ", false),
                    Option("سَيَصۡلٰى نَارًا ذَاتَ لَهَبٍ", true),
                    Option("مَاۤ اَغۡنٰى عَنۡهُ مَالُهٗ وَمَا كَسَبَؕ", false)),
            null, QuestionType.MultipleChoice)

    // all surah
    content.add(Surah("Al-Fatihah", fatihah, listOf(fatihah_1, fatihah_2, fatihah_3, fatihah_4)))
    content.add(Surah("Al-Lahab", al_lahab, listOf(lahab_1, lahab_2, lahab_3, lahab_4)))
    content.add(Surah("Al-Ikhlas", al_ikhlas, listOf(ikhlas_1, ikhlas_2, ikhlas_3, ikhlas_4)))
    content.add(Surah("Al-Falaq", al_falaq, listOf(falaq_1, falaq_2, falaq_3, falaq_4)))
    content.add(Surah("An-Naas", an_naas, listOf(naas_1, naas_2, naas_3, naas_4)))
}