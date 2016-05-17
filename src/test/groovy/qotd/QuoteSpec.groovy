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

    def "test for valid quote text"() {
        when: ’text is empty’
        def p = new Quote(text: ’’)
        then: 'validation should fail'
        !p.validate()

        /*
        when: 'test is null'
        def n = new Quote(text: null)
        then: 'validation should fail'
        !n.validate()

        when: 'test is valid text'
        def l = new Quote(text: 'Hello')
        then: 'validate should pass'
        !l.validate()
        */
    }

    def "test for null"(){
      when: 'test is null'
      def n = new Quote(text: null)
      then: 'validation should fail'
      !n.validate()
    }

    def "test for valid text"(){
      when: 'test is valid text'
      def l = new Quote(text: 'Hello')
      then: 'validation should pass'
      !l.validate()
    }


    def cleanup() {
    }
}
