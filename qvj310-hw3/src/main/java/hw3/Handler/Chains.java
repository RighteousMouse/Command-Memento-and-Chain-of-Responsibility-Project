package hw3.Handler;

public class Chains {

    public boolean inSelectChain(String word) {
        for(SelectChain chain: SelectChain.values()) {
            if (word.equals(chain.getSelectChain())) {
                return true;
            }
        }
        return false;
    }

    public boolean inNonSelectChain(String word) {
        for(NonSelectChain chain: NonSelectChain.values()) {
            if (word.equals(chain.getNonSelectChain())) {
                return true;
            }
        }
        return false;
    }

    public enum SelectChain {
        MOVE("MOVE"),
        COLOR("COLOR"),
        DRAW("DRAW"),
        DELETE("DELETE");

        private String selectChain;

        SelectChain(String selectChain) {
            this.selectChain = selectChain;
        }

        public String getSelectChain() {
            return selectChain;
        }

    }

    public enum NonSelectChain {
        CREATE("CREATE"),
        SELECT("SELECT"),
        UNDO("UNDO"),
        DRAWSCENE("DRAWSCENE");

        private String nonSelectChain;

        NonSelectChain(String nonSelectString) {
            this.nonSelectChain = nonSelectString;
        }

        public String getNonSelectChain() {
            return nonSelectChain;
        }
    }
    
}
