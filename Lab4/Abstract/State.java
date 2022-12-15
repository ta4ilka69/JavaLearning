package Abstract;

public enum State {
    Fly("летает"),
    Stay("стоит"),
    Swim("плавает"),
    Fall("падает"),
    FastFall("быстро падает"),
    Levitate("левитирует"),
    Undefined("не определился"),
    Lazy("ленится"),
    ForgetTarget("забыла о цели"),
    Lay("лежит");
    private final String state;
    State(String state){
        this.state = state;
    }

    public String getState() {
        return this.state.toString();
    }
}
