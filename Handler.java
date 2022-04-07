/**
 * 处理器
*/
public interface Handler<R extends Serializable> {
  /**
   * 获得提交类型(返回值也可以使用已经存在的枚举类)
   *
   * @return 类型
  */
  String getType();
  /**
   * 处理
   *
   * @param request 请求
   * @return left 为返回信息，right 为业务值
  */
  CommonPair<String, R> handle(Request request);
}
