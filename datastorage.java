import java.util.ArrayList;

    public class datastorage {
        private static datastorage instance;

        public ArrayList<Object[]> Dashboard = new ArrayList<>();

        public ArrayList<Object[]> Confirmation = new ArrayList<>();

            private datastorage(){

            }

        public static datastorage getInstance() {
            if (instance == null) {
                instance = new datastorage();
            }
            return instance;
        }
    }


