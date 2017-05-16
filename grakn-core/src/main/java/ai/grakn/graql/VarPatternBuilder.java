/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016  Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Grakn. If not, see <http://www.gnu.org/licenses/gpl.txt>.
 *
 */

package ai.grakn.graql;

import ai.grakn.concept.ConceptId;
import ai.grakn.concept.ResourceType;
import ai.grakn.concept.TypeLabel;

import javax.annotation.CheckReturnValue;

/**
 * @author Felix Chapman
 */
public interface VarPatternBuilder extends PatternBuilder {
    /**
     * @param id a ConceptId that this variable's ID must match
     * @return this
     */
    @CheckReturnValue
    VarPattern id(ConceptId id);

    /**
     * @param label a string that this variable's label must match
     * @return this
     */
    @CheckReturnValue
    VarPattern label(String label);

    /**
     * @param label a type label that this variable's label must match
     * @return this
     */
    @CheckReturnValue
    VarPattern label(TypeLabel label);

    /**
     * @param value a value that this variable's value must exactly match
     * @return this
     */
    @CheckReturnValue
    VarPattern val(Object value);

    /**
     * @param predicate a atom this variable's value must match
     * @return this
     */
    @CheckReturnValue
    VarPattern val(ValuePredicate predicate);

    /**
     * the variable must have a resource of the given type with an exact matching value
     *
     * @param type a resource type in the ontology
     * @param value a value of a resource
     * @return this
     */
    @CheckReturnValue
    VarPattern has(String type, Object value);

    /**
     * the variable must have a resource of the given type that matches the given atom
     *
     * @param type a resource type in the ontology
     * @param predicate a atom on the value of a resource
     * @return this
     */
    @CheckReturnValue
    VarPattern has(String type, ValuePredicate predicate);

    /**
     * the variable must have a resource of the given type that matches the given atom
     *
     * @param type a resource type in the ontology
     * @param var a variable representing a resource
     * @return this
     */
    @CheckReturnValue
    VarPattern has(String type, VarPatternBuilder var);

    /**
     * the variable must have a resource of the given type that matches the given atom
     *
     * @param type a resource type in the ontology
     * @param var a variable representing a resource
     * @return this
     */
    @CheckReturnValue
    VarPattern has(TypeLabel type, VarPatternBuilder var);

    /**
     * @param type a concept type id that the variable must be of this type
     * @return this
     */
    @CheckReturnValue
    VarPattern isa(String type);

    /**
     * @param type a concept type that this variable must be an instance of
     * @return this
     */
    @CheckReturnValue
    VarPattern isa(VarPatternBuilder type);

    /**
     * @param type a concept type id that this variable must be a kind of
     * @return this
     */
    @CheckReturnValue
    VarPattern sub(String type);

    /**
     * @param type a concept type that this variable must be a kind of
     * @return this
     */
    @CheckReturnValue
    VarPattern sub(VarPatternBuilder type);

    /**
     * @param type a role type id that this relation type variable must have
     * @return this
     */
    @CheckReturnValue
    VarPattern relates(String type);

    /**
     * @param type a role type that this relation type variable must have
     * @return this
     */
    @CheckReturnValue
    VarPattern relates(VarPatternBuilder type);

    /**
     * @param type a role type id that this concept type variable must play
     * @return this
     */
    @CheckReturnValue
    VarPattern plays(String type);

    /**
     * @param type a role type that this concept type variable must play
     * @return this
     */
    @CheckReturnValue
    VarPattern plays(VarPatternBuilder type);

    /**
     * @param type a scope that this variable must have
     * @return this
     */
    @CheckReturnValue
    VarPattern hasScope(VarPatternBuilder type);

    /**
     * @param type a resource type that this type variable can be related to
     * @return this
     */
    @CheckReturnValue
    VarPattern has(String type);

    /**
     * @param type a resource type that this type variable can be related to
     * @return this
     */
    @CheckReturnValue
    VarPattern has(VarPatternBuilder type);

    /**
     * @param type a resource type that this type variable can be one-to-one related to
     * @return this
     */
    @CheckReturnValue
    VarPattern key(String type);

    /**
     * @param type a resource type that this type variable can be one-to-one related to
     * @return this
     */
    @CheckReturnValue
    VarPattern key(VarPatternBuilder type);

    /**
     * the variable must be a relation with the given roleplayer
     *
     * @param roleplayer a variable representing a roleplayer
     * @return this
     */
    @CheckReturnValue
    VarPattern rel(String roleplayer);

    /**
     * the variable must be a relation with the given roleplayer
     *
     * @param roleplayer a variable representing a roleplayer
     * @return this
     */
    @CheckReturnValue
    VarPattern rel(VarPatternBuilder roleplayer);

    /**
     * the variable must be a relation with the given roleplayer playing the given roletype
     *
     * @param roletype   a role type in the ontology
     * @param roleplayer a variable representing a roleplayer
     * @return this
     */
    @CheckReturnValue
    VarPattern rel(String roletype, String roleplayer);

    /**
     * the variable must be a relation with the given roleplayer playing the given roletype
     *
     * @param roletype   a variable representing a roletype
     * @param roleplayer a variable representing a roleplayer
     * @return this
     */
    @CheckReturnValue
    VarPattern rel(VarPatternBuilder roletype, String roleplayer);

    /**
     * the variable must be a relation with the given roleplayer playing the given roletype
     *
     * @param roletype   a role type in the ontology
     * @param roleplayer a variable representing a roleplayer
     * @return this
     */
    @CheckReturnValue
    VarPattern rel(String roletype, VarPatternBuilder roleplayer);

    /**
     * the variable must be a relation with the given roleplayer playing the given roletype
     *
     * @param roletype   a variable representing a roletype
     * @param roleplayer a variable representing a roleplayer
     * @return this
     */
    @CheckReturnValue
    VarPattern rel(VarPatternBuilder roletype, VarPatternBuilder roleplayer);

    /**
     * set this concept type variable as abstract, meaning it cannot have direct instances
     * @return this
     */
    @CheckReturnValue
    VarPattern isAbstract();

    /**
     * @param datatype the datatype to set for this resource type variable
     * @return this
     */
    @CheckReturnValue
    VarPattern datatype(ResourceType.DataType<?> datatype);

    /**
     * Specify the regular expression instances of this resource type must match
     * @param regex the regex to set for this resource type variable
     * @return this
     */
    @CheckReturnValue
    VarPattern regex(String regex);

    /**
     * @param lhs the left-hand side of this rule
     * @return this
     */
    @CheckReturnValue
    VarPattern lhs(Pattern lhs);

    /**
     * @param rhs the right-hand side of this rule
     * @return this
     */
    @CheckReturnValue
    VarPattern rhs(Pattern rhs);

    /**
     * Specify that the variable is different to another variable
     * @param varName the variable name that this variable should not be equal to
     * @return this
     */
    @CheckReturnValue
    VarPattern neq(String varName);

    /**
     * Specify that the variable is different to another variable
     * @param var the variable that this variable should not be equal to
     * @return this
     */
    @CheckReturnValue
    VarPattern neq(VarPatternBuilder var);

    @Override
    VarPattern pattern();
}