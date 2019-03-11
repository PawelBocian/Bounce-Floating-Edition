public class Score {

        private int points;
        private String nickName;

        public Score(int points,String nickName) {
            this.points = points;
            this.nickName = nickName;
        }
        //Getter of record points
        public int get_points()
        {
            return this.points;
        }

        //Special function used while writing data into scoreboard
        public String print_score()
        {
            String score = this.nickName + "  " + this.points;
            return score;
        }
    }
