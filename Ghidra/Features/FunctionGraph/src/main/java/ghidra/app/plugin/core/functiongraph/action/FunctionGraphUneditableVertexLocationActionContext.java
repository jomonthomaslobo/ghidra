/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.app.plugin.core.functiongraph.action;

import ghidra.app.context.ProgramActionContext;
import ghidra.app.plugin.core.functiongraph.FGProvider;
import ghidra.app.plugin.core.functiongraph.graph.vertex.FGVertex;

import java.util.Set;

public class FunctionGraphUneditableVertexLocationActionContext extends ProgramActionContext
		implements FunctionGraphVertexLocationContextIf {

	private final VertexActionContextInfo vertexInfo;

	public FunctionGraphUneditableVertexLocationActionContext(
			FGProvider functionGraphProvider, VertexActionContextInfo vertexInfo) {
		super(functionGraphProvider, functionGraphProvider.getProgram());

		if (vertexInfo == null) {
			throw new NullPointerException("VertexActionContextInfo cannot be null");
		}

		this.vertexInfo = vertexInfo;
	}

	@Override
	public Set<FGVertex> getSelectedVertices() {
		return vertexInfo.getSelectedVertices();
	}

	@Override
	public FGVertex getVertex() {
		return vertexInfo.getActiveVertex();
	}

	@Override
	public VertexActionContextInfo getVertexInfo() {
		return vertexInfo;
	}
}
