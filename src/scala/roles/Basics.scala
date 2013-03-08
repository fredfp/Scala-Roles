/*
 * Copyright (c) 2008, Michael Pradel
 * All rights reserved. See LICENSE for details.
 */

package scala.roles;

import internal.Collaboration
import internal.HasCore

object Basics {

  implicit def anyRef2HasAs[Player <: AnyRef](o: Player) = new HasAs[Player] { val core = o }

  trait HasAs[Player <: AnyRef] {
    val core: Player
    
    def as[RoleType <: TransientCollaboration#Role[Player]](role: RoleType): core.type with RoleType =
      (core -: role).asInstanceOf[core.type with RoleType]

    def as[RoleType <: TransientCollaboration#AbstractRole[Player]](rolemapper: TransientCollaboration#RoleMapper[Player, RoleType]): RoleType with core.type =
      (core -: rolemapper).asInstanceOf[RoleType with core.type]
  }
}

