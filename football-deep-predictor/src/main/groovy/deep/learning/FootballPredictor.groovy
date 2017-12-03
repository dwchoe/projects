package deep.learning

class FootballPredictor {

    static void main(String[] args) {
        def minnesota = [name: 'minnesota', off_passing: 2764, off_passing_game: 251, off_rushing: 1369, off_rushing_game: 125,
        def_passing: 2364, def_passing_game: 215, def_rushing: 830, def_rushing_game: 76]

        def atlanta = [name: 'atlanta', off_passing: 2882, off_passing_game: 257, off_rushing: 1285, off_rushing_game: 117,
        def_passing: 2287, def_passing_game: 208, def_rushing: 1253, def_rushing_game: 113]

        def detroit = [name: 'detroit', off_passing: 2812, off_passing_game: 256, off_rushing: 861, off_rushing_game: 78,
        def_passing: 2675, def_passing_game: 243, def_rushing: 1278, def_rushing_game: 116]

        def new_england = [name: 'new_england', off_passing: 3267, off_passing_game: 297, off_rushing: 1256, off_rushing_game: 114,
        def_passing: 2974, def_passing_game: 270, def_rushing: 1266, def_rushing_game: 115]

        def washington = [name: 'washington', off_passing: 2993, off_passing_game: 249, off_rushing: 1204, off_rushing_game: 100,
        def_passing: 2669, def_passing_game: 222, def_rushing: 1412, def_rushing_game: 117]

        def new_orleans = [name: 'new_orleans', off_passing: 2940, off_passing_game: 267, off_rushing: 1563, off_rushing_game: 142,
        def_passing: 2440, def_passing_game: 222, def_rushing: 1242, def_rushing_game: 113]

        def tampa_bay = [name: 'tampa_bay', off_passing: 2909, off_passing_game: 264, off_rushing: 892, off_rushing_game: 81,
        def_passing: 3131, def_passing_game: 285, def_rushing: 1220, def_rushing_game: 111]

        def la_chargers = [name: 'la_chargers', off_passing: 2903, off_passing_game: 264, off_rushing: 1025, off_rushing_game: 93,
        def_passing: 2266, def_passing_game: 206, def_rushing: 1468, def_rushing_game: 1134]

        def pittsburgh = [name: 'pittsburgh', off_passing: 2892, off_passing_game: 263, off_rushing: 1145, off_rushing_game: 104,
        def_passing: 2127, def_passing_game: 193, def_rushing: 1056, def_rushing_game: 96]

        def cleveland = [name: 'cleveland', off_passing: 2231, off_passing_game: 203, off_rushing: 1181, off_rushing_game: 107,
        def_passing: 2429, def_passing_game: 221, def_rushing: 1069, def_rushing_game: 97]

        def buffalo = [name: 'buffalo', off_passing: 2008, off_passing_game: 183, off_rushing: 1281, off_rushing_game: 117,
        def_passing: 2650, def_passing_game: 241, def_rushing: 1254, def_rushing_game: 114]

        def baltimore = [name: 'baltimore', off_passing: 1807, off_passing_game: 164, off_rushing: 1285, off_rushing_game: 117,
        def_passing: 2089, def_passing_game: 190, def_rushing: 1274, def_rushing_game: 116]

        def kansas_city = [name: 'kansas_city', off_passing: 2706, off_passing_game: 246, off_rushing: 1256, off_rushing_game: 114,
        def_passing: 2702, def_passing_game: 246, def_rushing: 1396, def_rushing_game: 127]

        def ny_jets = [name: 'ny_jets', off_passing: 2335, off_passing_game: 212, off_rushing: 1125, off_rushing_game: 102,
        def_passing: 2444, def_passing_game: 222, def_rushing: 1324, def_rushing_game: 120]

        def san_fran = [name: 'san_fran', off_passing: 2440, off_passing_game: 222, off_rushing: 1099, off_rushing_game: 100,
        def_passing: 2691, def_passing_game: 245, def_rushing: 1425, def_rushing_game: 130]

        def chicago = [name: 'chicago', off_passing: 1838, off_passing_game: 167, off_rushing: 1324, off_rushing_game: 120,
        def_passing: 2374, def_passing_game: 216, def_rushing: 1236, def_rushing_game: 112]

        def carolina = [name: 'carolina', off_passing: 2244, off_passing_game: 204, off_rushing: 1421, off_rushing_game: 129,
        def_passing: 2256, def_passing_game: 205, def_rushing: 915, def_rushing_game: 83]

        def cincinnati = [name: 'cincinnati', off_passing: 2185, off_passing_game: 199, off_rushing: 832, off_rushing_game: 76,
        def_passing: 2242, def_passing_game: 204, def_rushing: 1393, def_rushing_game: 127]

        def green_bay = [name: 'green_bay', off_passing: 2291, off_passing_game: 208, off_rushing: 1104, off_rushing_game: 100,
        def_passing: 2685, def_passing_game: 244, def_rushing: 1178, def_rushing_game: 107]

        calc(ny_jets, kansas_city)
        calc(chicago, san_fran)
        calc(buffalo, new_england)
        calc(baltimore, detroit)
        calc(atlanta, minnesota)
        calc(new_orleans, carolina)
        calc(la_chargers, cleveland)
        calc(cincinnati, pittsburgh)

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
