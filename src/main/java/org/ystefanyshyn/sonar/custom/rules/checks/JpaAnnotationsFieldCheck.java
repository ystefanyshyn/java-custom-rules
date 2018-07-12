package org.ystefanyshyn.sonar.custom.rules.checks;

import com.google.common.collect.ImmutableList;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

@Rule(
        key = "JpaAnnotationsFieldCheck",
        name = "Javax persistence annotations should be placed on accessors",
        description = "Javax persistence annotations should be placed on accessors",
        priority = Priority.MAJOR,
        tags = {"bug"})
public class JpaAnnotationsFieldCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.ANNOTATION);
    }

    @Override
    public void visitNode(Tree tree) {
        if (!(tree instanceof AnnotationTree)) {
            return;
        }
        AnnotationTree annotation = (AnnotationTree) tree;

        if (annotation.parent().parent().is(Tree.Kind.VARIABLE)) {
            IdentifierTree idf = (IdentifierTree) annotation.annotationType();

            if (idf.symbol().owner().name().contains("javax.persistence")) {
                reportIssue(annotation, "Javax persistence annotations should be placed on accessors");
            }
        }
    }
}
