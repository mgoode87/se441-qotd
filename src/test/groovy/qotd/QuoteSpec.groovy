package qotd

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Quote)
class QuoteSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test for valid quote text"() {
        when: ’text is empty’
        def p = new Quote(text: ’’)
        then: 'validation should fail'
        !p.validate()
    }

    def "test for null"(){
      when: 'test is null'
      def p = new Quote(text: null)
      then: 'validation should fail'
      !p.validate()
    }

    def "test for valid text"(){
      when: 'test is valid text'
      def p = new Quote(text: 'Hello')
      then: 'validation should pass'
      !p.validate()
    }



}
