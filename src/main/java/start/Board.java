package start;

import java.util.List;

/**
 * @author Jakub Czajka
 */
class Board  {
  int length;
  int heigth;
  private List<Field> fields;

  public Board(List<Field> fields) {
    this.fields = fields;
  }

  String getFieldInfo(int fieldNumber){
    return fieldNumber+"";
  }

  Field getField(int fieldNumber){
    return fields.get(fieldNumber);
  }
}
