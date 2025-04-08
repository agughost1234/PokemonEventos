public enum Tipo_ataque_pokemon {
    FUEGO(new String[]{"Infiernum", "inceniracion derretidora", "Ultrafuego", "Calor infrajuliano", "Explosion infernal", "Lavabosa", "fueguisimo", "Latigo lava", "Bola de fuego", "Llamarada"}, null),
    AGUA(new String[]{"Tsunami", "Olas mangnificas", "Hydroespada", "Ventisca helada", "Gotas abismales", "Rafagahidro", "Superchapuson", "Cascadadon", "Bombaguaso", "Chorrito de agua"}, null),
    PLANTA(new String[]{"Humoextravenenoso", "Lazos venenoso", "Espiral de espinas", "Semillerar", "Rodatronco", "Raices opresivas", "Enredadera", "Cañon frutas", "lluvia de hojas", "Hojazo"}, null),
    ELECTRICO(new String[]{"Rayolaser", "Electrorapinito", "Ferroinstataque", "Impacto sobrelectrizante", "Megatormenta electrica", "Corriente de rayos", "", "Electrimaximo", "Corrientazo", "Chispas"}, null),
    TIERRA(new String[]{"Montaña", "Sumergimiento placoso", "Bloque diamante", "Lodo Hyperarenoso", "Lanzamontes", "Enmurallar", "Apreton de arcilla", "Tierra sucias", "Rocal", "Polvo"},null);
    
    private String[] ataques;
    private Tipo_ataque_pokemon[] counter;

    private Tipo_ataque_pokemon(String[] ataques, Tipo_ataque_pokemon[] counter) {
        this.ataques = ataques;
        this.counter = counter;
    }

    public String[] get_ataques() {
        return ataques;
    }

    public Tipo_ataque_pokemon[] get_counter() {
        return counter;
    }
    
    static { 
        FUEGO.counter = new Tipo_ataque_pokemon[]{AGUA};
        AGUA.counter = new Tipo_ataque_pokemon[]{PLANTA};
        PLANTA.counter = new Tipo_ataque_pokemon[]{FUEGO};
        ELECTRICO.counter = new Tipo_ataque_pokemon[]{TIERRA, PLANTA};
        TIERRA.counter = new Tipo_ataque_pokemon[]{ELECTRICO, AGUA};
    }
}
