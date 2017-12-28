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

        calc(atlanta, minnesota)
        calc(minnesota, detroit)
        calc(washington, minnesota)
        calc(minnesota, new_orleans)
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
            def total_passing = (visitor['def_passing_game'] + (passing_diff / 5))
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
            def total_rushing = (visitor['def_rushing_game'] + (rushing_diff / 5))
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
            def total_passing = (visitor['off_passing_game'] + (passing_diff / 5))
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
            def total_rushing = (visitor['off_rushing_game'] + (rushing_diff / 5))
            visitor_tds = visitor_tds + (total_rushing / 100)
            println('visitor passing: ' + visitor['name'] + ' ' + total_rushing)
        }

        def home_score = home_tds * 7
        def visitor_score = visitor_tds * 7
        def winner = (home_score > visitor_score) ? home['name'] : visitor['name']
        println(home['name'] + ":" + home_score + " vs " + visitor['name'] + ":" + visitor_score + " => " +
        winner + " wins")
    }
}
