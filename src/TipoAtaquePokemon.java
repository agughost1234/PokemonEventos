public enum TipoAtaquePokemon {
    FUEGO(new String[]{"Infiernum", "inceniracion derretidora", "Ultrafuego", "Calor infrajuliano", "Explosion infernal", "Lavabosa", "fueguisimo", "Latigo lava", "Bola de fuego", "Llamarada"}, null),
    AGUA(new String[]{"Tsunami", "Olas mangnificas", "Hydroespada", "Ventisca helada", "Gotas abismales", "Rafagahidro", "Superchapuson", "Cascadadon", "Bombaguaso", "Chorrito de agua"}, null),
    PLANTA(new String[]{"Humoextravenenoso", "Lazos venenoso", "Espiral de espinas", "Semillerar", "Rodatronco", "Raices opresivas", "Enredadera", "Cañon frutas", "lluvia de hojas", "Hojazo"}, null),
    ELECTRICO(new String[]{"Rayolaser", "Electrorapinito", "Ferroinstataque", "Impacto sobrelectrizante", "Megatormenta electrica", "Corriente de rayos", "", "Electrimaximo", "Corrientazo", "Chispas"}, null),
    TIERRA(new String[]{"Montaña", "Sumergimiento placoso", "Bloque diamante", "Lodo Hyperarenoso", "Lanzamontes", "Enmurallar", "Apreton de arcilla", "Tierra sucias", "Rocal", "Polvo"}, null);
    
    private String[] ataques;
    private TipoAtaquePokemon[] counter;

    private TipoAtaquePokemon(String[] ataques, TipoAtaquePokemon[] counter) {
        this.ataques = ataques;
        this.counter = counter;
    }

    public String[] getAtaques() {
        return ataques;
    }

    public TipoAtaquePokemon[] getCounter() {
        return counter;
    }
    
    static { 
        FUEGO.counter = new TipoAtaquePokemon[]{AGUA};
        AGUA.counter = new TipoAtaquePokemon[]{PLANTA};
        PLANTA.counter = new TipoAtaquePokemon[]{FUEGO};
        ELECTRICO.counter = new TipoAtaquePokemon[]{TIERRA, PLANTA};
        TIERRA.counter = new TipoAtaquePokemon[]{ELECTRICO, AGUA};
    }
}