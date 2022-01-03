package com.graphql.test.pojos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class GraphQLQuery {
    private String query;
    private Object variables;


}
