package fi.aalto.cs.drumbeat.ifc.data.metamodel;

import fi.aalto.cs.drumbeat.ifc.common.IfcNotFoundException;
import fi.aalto.cs.drumbeat.ifc.data.IfcVocabulary;
import fi.aalto.cs.drumbeat.ifc.data.model.IfcEntity;
import fi.aalto.cs.drumbeat.ifc.data.model.IfcModelBase;
import fi.aalto.cs.drumbeat.ifc.data.schema.IfcSchema;

public class IfcMetaModel extends IfcModelBase {
	
	private IfcStepFileDescription fileDescription;
	private IfcStepFileName fileName;
	private IfcStepFileSchema fileSchema;

	public IfcMetaModel(IfcSchema stepSchema) {
		super(stepSchema);
	}

	public IfcStepFileDescription getFileDescription() throws IfcNotFoundException {
		if (fileDescription == null) {
			IfcEntity entity = super.getFirstEntityByType(IfcVocabulary.SpfFormat.Header.FileDescription.TYPE_NAME);
			fileDescription = new IfcStepFileDescription(entity);
		}
		return fileDescription;
	}

	public IfcStepFileName getFileName() throws IfcNotFoundException {
		if (fileName == null) {
			IfcEntity entity = super.getFirstEntityByType(IfcVocabulary.SpfFormat.Header.FileName.TYPE_NAME);
			fileName = new IfcStepFileName(entity);
		}
		return fileName;
	}

	public IfcStepFileSchema getFileSchema() throws IfcNotFoundException {
		if (fileSchema == null) {
			IfcEntity entity = super.getFirstEntityByType(IfcVocabulary.SpfFormat.Header.FileSchema.TYPE_NAME);
			fileSchema = new IfcStepFileSchema(entity);
		}
		return fileSchema;
	}
	
	

}
