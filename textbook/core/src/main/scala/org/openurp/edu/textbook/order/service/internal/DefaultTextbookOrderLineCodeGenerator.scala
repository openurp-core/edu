package org.openurp.edu.textbook.order.service.internal

import java.util.UUID
import org.openurp.edu.textbook.order.service.TextbookOrderLineCodeGenerator
import org.openurp.edu.textbook.order.TextbookOrderLine

class DefaultTextbookOrderLineCodeGenerator extends TextbookOrderLineCodeGenerator {

  def genCode(orderLine: TextbookOrderLine): String = {
    UUID.randomUUID().toString.substring(0, 16)
  }
}
