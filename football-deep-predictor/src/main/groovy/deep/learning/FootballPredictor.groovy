package deep.learning

class FootballPredictor {

    static void main(String[] args) {
        def arizona = [name: 'arizona', off_passing_game: 233, off_rushing_game: 85, def_passing_game: 223, def_rushing_game: 89]

        def atlanta = [name: 'atlanta', off_passing_game: 257, off_rushing_game: 119, def_passing_game: 208, def_rushing_game: 105]

        def baltimore = [name: 'baltimore', off_passing_game: 189, off_rushing_game: 116, def_passing_game: 214, def_rushing_game: 116]

        def buffalo = [name: 'buffalo', off_passing_game: 176, off_rushing_game: 126, def_passing_game: 228, def_rushing_game: 127]

        def carolina = [name: 'carolina', off_passing_game: 194, off_rushing_game: 134, def_passing_game: 224, def_rushing_game: 90]

        def chicago = [name: 'chicago', off_passing_game: 176, off_rushing_game: 117, def_passing_game: 213,  def_rushing_game: 106]

        def cincinnati = [name: 'cincinnati', off_passing_game: 194, off_rushing_game: 81, def_passing_game: 212, def_rushing_game: 129]

        def cleveland = [name: 'cleveland', off_passing_game: 197, off_rushing_game: 108, def_passing_game: 231, def_rushing_game: 96]

        def dallas = [name: 'dallas', off_passing_game: 198, off_rushing_game: 136, def_passing_game: 218, def_rushing_game: 106]

        def denver = [name: 'denver', off_passing_game: 207, off_rushing_game: 116, def_passing_game: 196, def_rushing_game: 88]

        def detroit = [name: 'detroit', off_passing_game: 259, off_rushing_game: 78, def_passing_game: 249, def_rushing_game: 113]

        def green_bay = [name: 'green_bay', off_passing_game: 201, off_rushing_game: 108, def_passing_game: 232, def_rushing_game: 116]

        def houston = [name: 'houston', off_passing_game: 210, off_rushing_game: 117, def_passing_game: 246, def_rushing_game: 107]

        def indianapolis = [name: 'indianapolis', off_passing_game: 186, off_rushing_game: 101, def_passing_game: 255, def_rushing_game: 123]

        def jacksonville = [name: 'jacksonville', off_passing_game: 230, off_rushing_game: 145, def_passing_game: 173, def_rushing_game: 116]

        def kansas_city = [name: 'kansas_city', off_passing_game: 256, off_rushing_game: 120, def_passing_game: 248, def_rushing_game: 119]

        def la_chargers = [name: 'la_chargers', off_passing_game: 270, off_rushing_game: 99, def_passing_game: 195, def_rushing_game: 133]

        def la_rams = [name: 'la_rams', off_passing_game: 245, off_rushing_game: 123, def_passing_game: 212, def_rushing_game: 119]

        def miami = [name: 'miami', off_passing_game: 218, off_rushing_game: 86, def_passing_game: 228, def_rushing_game: 110]

        def minnesota = [name: 'minnesota', off_passing_game: 238, off_rushing_game: 121, def_passing_game: 194, def_rushing_game: 87]

        def new_england = [name: 'new_england', off_passing_game: 282, off_rushing_game: 116, def_passing_game: 254, def_rushing_game: 120]

        def new_orleans = [name: 'new_orleans', off_passing_game: 264, off_rushing_game: 132, def_passing_game: 217, def_rushing_game: 112]

        def ny_giants = [name: 'ny_giants', off_passing_game: 224, off_rushing_game: 86, def_passing_game: 260, def_rushing_game: 125]

        def ny_jets = [name: 'ny_jets', off_passing_game: 198, off_rushing_game: 111, def_passing_game: 238, def_rushing_game: 116]

        def oakland = [name: 'oakland', off_passing_game: 227, off_rushing_game: 97, def_passing_game: 232, def_rushing_game: 109]

        def philadelphia = [name: 'philadelphia', off_passing_game: 239, off_rushing_game: 136, def_passing_game: 231, def_rushing_game: 76]

        def pittsburgh = [name: 'pittsburgh', off_passing_game: 277, off_rushing_game: 103, def_passing_game: 196, def_rushing_game: 106]

        def san_fran = [name: 'san_fran', off_passing_game: 242, off_rushing_game: 100, def_passing_game: 241, def_rushing_game: 117]

        def seattle = [name: 'seattle', off_passing_game: 231, off_rushing_game: 102, def_passing_game: 214, def_rushing_game: 114]

        def tampa_bay = [name: 'tampa_bay', off_passing_game: 268, off_rushing_game: 89, def_passing_game: 263, def_rushing_game: 119]

        def tennessee = [name: 'tennessee', off_passing_game: 205, off_rushing_game: 115, def_passing_game: 245, def_rushing_game: 89]

        def washington = [name: 'washington', off_passing_game: 241, off_rushing_game: 93, def_passing_game: 220, def_rushing_game: 126]

        // calculate games
        calc(minnesota, chicago)
        calc(detroit, green_bay)
        calc(indianapolis, houston)
        calc(new_england, ny_jets)
        calc(ny_giants, washington)
        calc(philadelphia, dallas)
        calc(pittsburgh, cleveland)
        calc(atlanta, carolina)
        calc(denver, kansas_city)
        calc(tennessee, jacksonville)
        calc(la_rams, san_fran)
        calc(miami, buffalo)
        calc(la_chargers, oakland)
        calc(seattle, arizona)
        calc(tampa_bay, new_orleans)
        calc(baltimore, cincinnati)

    }

    private static void calc(Map home, Map visitor) {
        def home_tds = 0
        def visitor_tds = 0

        println()
        // home passing
        if ( home['off_passing_game'] > visitor['def_passing_game'] ) {
            def passing_diff = home['off_passing_game'] - visitor['def_passing_game']
            def total_passing = (visitor['def_passing_game'] + (passing_diff / 4))
            home_tds = total_passing / 100
            println('home passing: ' + home['name'] + ' ' + total_passing)
        }
        else {
            def passing_diff = visitor['def_passing_game'] - home['off_passing_game']
            def total_passing = (visitor['def_passing_game'] - (passing_diff / 5))
            home_tds = total_passing / 100
            println('home passing: ' + home['name'] + ' ' + total_passing)
        }

        // home rushing
        if ( home['off_rushing_game'] > visitor['def_rushing_game'] ) {
            def rushing_diff = home['off_rushing_game'] - visitor['def_rushing_game']
            def total_rushing = (visitor['def_rushing_game'] + (rushing_diff / 4))
            home_tds = home_tds + (total_rushing / 100)
            println('home rushing: ' + home['name'] + ' ' + total_rushing)
        }
        else {
            def rushing_diff = visitor['def_rushing_game'] - home['off_rushing_game']
            def total_rushing = (visitor['def_rushing_game'] - (rushing_diff / 5))
            home_tds = home_tds + (total_rushing / 100)
            println('home passing: ' + home['name'] + ' ' + total_rushing)
        }



        // visitor passing
        if ( home['def_passing_game'] > visitor['off_passing_game'] ) {
            def passing_diff = home['def_passing_game'] - visitor['off_passing_game']
            def total_passing = (visitor['off_passing_game'] + (passing_diff / 4))
            visitor_tds = total_passing / 100
            println('visitor passing: ' + visitor['name'] + ' ' + total_passing)
        }
        else {
            def passing_diff = visitor['off_passing_game'] - home['def_passing_game']
            def total_passing = (visitor['off_passing_game'] - (passing_diff / 5))
            visitor_tds = total_passing / 100
            println('visitor passing: ' + visitor['name'] + ' ' + total_passing)
        }

        // visitor rushing
        if ( home['def_rushing_game'] > visitor['off_rushing_game'] ) {
            def rushing_diff = home['def_rushing_game'] - visitor['off_rushing_game']
            def total_rushing = (visitor['off_rushing_game'] + (rushing_diff / 4))
            visitor_tds = visitor_tds + (total_rushing / 100)
            println('visitor rushing: ' + visitor['name'] + ' ' + total_rushing)
        }
        else {
            def rushing_diff = visitor['off_rushing_game'] - home['def_rushing_game']
            def total_rushing = (visitor['off_rushing_game'] - (rushing_diff / 5))
            visitor_tds = visitor_tds + (total_rushing / 100)
            println('visitor rushing: ' + visitor['name'] + ' ' + total_rushing)
        }

        def home_score = home_tds * 7
        def visitor_score = visitor_tds * 7
        def winner = (home_score > visitor_score) ? home['name'] : visitor['name']
        println(home['name'] + ":" + home_score + " vs " + visitor['name'] + ":" + visitor_score + " => " +
        winner + " wins")
    }
}
