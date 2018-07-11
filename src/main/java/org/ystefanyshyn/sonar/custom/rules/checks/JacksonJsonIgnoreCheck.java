package org.ystefanyshyn.sonar.custom.rules.checks;

import com.google.common.collect.ImmutableList;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

/**
 * .
 */
@Rule(
        key = "JacksonJsonIgnoreCheck",
        name = "Jackson JsonIgnore annotation should not be used with fields",
        description = "Jackson JsonIgnore annotation should not be used with fields",
        priority = Priority.CRITICAL,
        tags = {"bug"})
public class JacksonJsonIgnoreCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.ANNOTATION);
    }

    @Override
    public void visitNode(Tree tree) {
        AnnotationTree annotation = (AnnotationTree) tree;
        if (annotation.parent().parent().is(Tree.Kind.VARIABLE)) {
            IdentifierTree idf = (IdentifierTree) annotation.annotationType();
            if (idf.name().equals("JsonIgnore")) {
                reportIssue(annotation, "LOL");
            }
        }
    }
}
