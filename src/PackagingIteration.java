public class PackagingIteration implements RicePackage {
    @Override
    public Bags packageRiceIntoBags(int oneKilo, int fiveKilo, int riceKilos) {
        Bags bags = new Bags();

        if ((fiveKilo * 5) + oneKilo < riceKilos) return bags;

        while (true) {
            if (riceKilos == 0) return bags;
            if (riceKilos > 5){
                if (fiveKilo > 0) {
                    riceKilos -= 5;
                    fiveKilo--;
                    bags.addOneToFiveKgBags();
                } else {
                    bags.addOneKgBags(riceKilos);
                    return bags;
                }
            } else if (riceKilos < 5){
                if (oneKilo >= riceKilos){
                    bags.addOneKgBags(riceKilos);
                }else {
                    bags.addOneToFiveKgBags();
                }
                return bags;
            }
        }
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
