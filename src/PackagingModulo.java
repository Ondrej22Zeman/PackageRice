public class PackagingModulo implements RicePackage {
    @Override
    public Bags packageRiceIntoBags(int oneKilo, int fiveKilo, int riceKilos) {
        Bags bags = new Bags();

        if ((oneKilo + fiveKilo * 5) < riceKilos) {
            return bags;
        }

        if (fiveKilo * 5 >= riceKilos) {
            if (oneKilo >= riceKilos % 5) {
                bags.setOneKiloBags(riceKilos % 5);
                bags.setFiveKiloBags(riceKilos / 5);
            } else {
                bags.setFiveKiloBags((int) Math.ceil(riceKilos / 5.0));
            }
            return bags;
        }

        bags.setOneKiloBags(riceKilos - fiveKilo * 5);
        if (fiveKilo != 0) {
            bags.setFiveKiloBags(fiveKilo);
        }
        return bags;
    }
    public String print(Bags bags){
        String ret;
        if (bags.getOneKiloBags() == 0){
            if (bags.getFiveKiloBags() == 0) {
                ret = "Rýži není možné zabalit";
                return ret;
            }
            ret = "Rýži je možné zabalit do " + bags.getFiveKiloBags() + " pětikilových pytlů";
        } else if (bags.getFiveKiloBags() == 0) {
            ret = "Rýži je možné zabalit do " + bags.getOneKiloBags() + " jednokilových pytlů";
        }else {
            ret = "Rýži je možné zabalit do " + bags.getOneKiloBags() + " jednokilových pytlů a "
                    + bags.getFiveKiloBags() + " pětikilových pytlů";
        }
        return ret;
    }
}
