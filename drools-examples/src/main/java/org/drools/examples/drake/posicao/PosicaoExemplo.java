package org.drools.examples.drake.posicao;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.examples.drake.posicao.domain.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.*;

/**
 * Created by pperboires on 10/03/14.
 */
public class PosicaoExemplo {

    public static final void main(final String[] args) {
        final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
                .newKnowledgeBuilder();

        // this will parse and compile in one step
        kbuilder.add( ResourceFactory.newClassPathResource("Posicao.drl",
                PosicaoExemplo.class),
                ResourceType.DRL );

        // Check the builder for errors
        if ( kbuilder.hasErrors() ) {
            System.out.println( kbuilder.getErrors().toString() );
            throw new RuntimeException( "Unable to compile \"Posicao.drl\"." );
        }

        // get the compiled packages (which are serializable)
        final Collection<KnowledgePackage> pkgs = kbuilder
                .getKnowledgePackages();

        // add the packages to a knowledgebase (deploy the knowledge packages).
        final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( pkgs );

        final StatefulKnowledgeSession ksession = kbase
                .newStatefulKnowledgeSession();
        ksession.setGlobal( "list",
                new ArrayList<Object>() );

        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugWorkingMemoryEventListener() );

        // setup the audit logging
        // Remove comment to use FileLogger
        // KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger( ksession, "./helloworld" );

        // Remove comment to use ThreadedFileLogger so audit view reflects events whilst debugging
        // KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newThreadedFileLogger( ksession, "./helloworld", 1000 );



        Trabalhador trabalhador = new Trabalhador(1000, "SHELDON COOPER");

        // TODO gerar posições iniciais a partir de um período.
        /*ksession.insert(new Posicao(1, 1, 2014, trabalhador));
        ksession.insert(new Posicao(2, 1, 2014, trabalhador));
        ksession.insert(new Posicao(3, 1, 2014, trabalhador));
        ksession.insert(new Posicao(4, 1, 2014, trabalhador));
        ksession.insert(new Posicao(5, 1, 2014, trabalhador));
*/
        // Escalas.
        ksession.insert(new Escala(1, 1, 2014, 14, 1, 2014, Escala.TRABALHO, trabalhador));
        ksession.insert(new Escala(15, 1, 2014, 28, 1, 2014, Escala.FOLGA, trabalhador));
        ksession.insert(new Escala(29, 1, 2014, 12, 2, 2014, Escala.TRABALHO, trabalhador));

        // Evento DRAKE.
        ksession.insert(new Evento(1, 1, 2014,  Evento.EMBARQUE, trabalhador));
        ksession.insert(new Evento(14, 1, 2014,  Evento.DESEMBARQUE, trabalhador));
        ksession.insert(new Evento(29, 1, 2014,  Evento.EMBARQUE, trabalhador));

        ksession.insert(new Parametro(1, 1,2014, 29,1,2014));

        ksession.fireAllRules();

        System.out.println("ESCALAS -------------------------------------------------------------------------------");

        for (Object objeto : ksession.getObjects())
        {
            if (objeto instanceof Escala)
            {
                System.out.println(objeto.toString());
            }
        }

        System.out.println("EVENTOS -------------------------------------------------------------------------------");

        for (Object objeto : ksession.getObjects())
        {
            if (objeto instanceof Evento)
            {
                System.out.println(objeto.toString());
            }
        }

        System.out.println("posicoes -------------------------------------------------------------------------------");

        for (Object objeto : ksession.getObjects())
        {
            if (objeto instanceof Posicao)
            {
                System.out.println(objeto.toString());
            }
        }

        // Remove comment if using logging
        // logger.close();

        ksession.dispose();
    }







}
