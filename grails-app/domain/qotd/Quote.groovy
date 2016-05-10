package qotd

class Quote {
    String text;

    static belongsTo = [attribution:attribution];

    //Made a change

    static constraints = {
      text nullable: false
      attribution nullable: true
    }
}
